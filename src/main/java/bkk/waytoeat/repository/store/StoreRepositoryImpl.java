package bkk.waytoeat.repository.store;

import bkk.waytoeat.domain.QStoreDate;
import bkk.waytoeat.dto.QStoreNameAndLinkDto;
import bkk.waytoeat.dto.ResponseNameRatingClosedDto;
import bkk.waytoeat.dto.ResponseStoreDetailDto;
import bkk.waytoeat.dto.StoreNameAndLinkDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static bkk.waytoeat.domain.QStoreDate.*;
import static com.querydsl.core.group.GroupBy.groupBy;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Map;

import static bkk.waytoeat.domain.QStore.*;
import static bkk.waytoeat.domain.QYoutube.*;
import static com.querydsl.core.group.GroupBy.list;
import static java.util.stream.Collectors.toList;

@Repository
public class StoreRepositoryImpl implements StoreRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public StoreRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    // 위도 경도를 받아 해당 상점 url 모두 반환
    public List<StoreNameAndLinkDto> searchWithLatAndLong(double latitude, double longitude) {

        Map<String, StoreNameAndLinkDto> result = queryFactory
                .from(youtube)
                .join(store)
                .on(youtube.phone.eq(store.phone))
                .where(
                        store.latitude.eq(latitude),
                        store.longitude.eq(longitude)
                )
                .transform(groupBy(store.name).as(new QStoreNameAndLinkDto(
                        store.name,
                        store.id,
                        list(youtube.url)
                )));

        return result.keySet().stream()
                .map(result::get)
                .collect(toList());
    }

    // id를 통해 해당 가게의 가게명, 평점, 영업유무 반환
    @Override
    public ResponseNameRatingClosedDto infoCardSearchWithId(String id) {
        ResponseNameRatingClosedDto result = queryFactory
                .select(Projections.constructor(
                        ResponseNameRatingClosedDto.class,
                        store.name,
                        store.naverRating,
                        store.kakaoRating,
                        store.selfRating,
                        storeDate.closed))
                .from(store)
                .leftJoin(storeDate)
                .on(store.id.eq(storeDate.store.id))
                .where(store.id.eq(id))
                .fetchOne();
        return result;
    }

    // 가게 상세정보
    @Override
    public ResponseStoreDetailDto getStoreDetail(String id) {
        ResponseStoreDetailDto result = queryFactory
                .select(Projections.constructor(
                        ResponseStoreDetailDto.class,
                        store.id,
                        store.name,
                        store.naverRatingDate,
                        store.naverRating,
                        store.kakaoRatingDate,
                        store.kakaoRating,
                        store.selfRating,
                        store.phone,
                        storeDate.closed,
                        storeDate.workMon,
                        storeDate.workTue,
                        storeDate.workWed,
                        storeDate.workThu,
                        storeDate.workFri,
                        storeDate.workSat,
                        storeDate.workSun,
                        store.menuImage
                ))
                .from(store)
                .leftJoin(storeDate)
                .on(store.id.eq(storeDate.store.id))
                .where(store.id.eq(id))
                .fetchOne();

        return result;
    }

}







