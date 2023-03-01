package bkk.waytoeat.repository.store;

import bkk.waytoeat.domain.QStore;
import bkk.waytoeat.dto.StoreNameAndLinkDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static bkk.waytoeat.domain.QStore.*;

@Repository
public class StoreRepositoryImpl implements StoreRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public StoreRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    // 위도 경도를 받아 해당 상점 id, 이름 반환
    @Override
    public StoreNameAndLinkDto searchWithLatAndLong(double latitude, double longitude) {
        StoreNameAndLinkDto result = queryFactory.
                select(Projections.constructor(StoreNameAndLinkDto.class,
                        store.name,
                        store.id))
                .from(store)
                .where(
                        store.latitude.eq(latitude),
                        store.longitude.eq(longitude)
                )
                .fetchOne();

        return result;
    }
}







