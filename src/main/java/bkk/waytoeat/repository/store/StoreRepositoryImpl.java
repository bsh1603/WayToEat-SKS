package bkk.waytoeat.repository.store;

import bkk.waytoeat.dto.QStoreNameAndLinkDto;
import bkk.waytoeat.dto.StoreNameAndLinkDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
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
}







