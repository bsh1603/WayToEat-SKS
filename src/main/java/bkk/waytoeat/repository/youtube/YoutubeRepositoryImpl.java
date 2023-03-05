package bkk.waytoeat.repository.youtube;

import bkk.waytoeat.domain.QYoutube;
import bkk.waytoeat.domain.Store;
import bkk.waytoeat.dto.ResponseNameToIdsDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bkk.waytoeat.domain.QYoutube.*;

@Repository
@Slf4j
public class YoutubeRepositoryImpl implements YoutubeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public YoutubeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    // 이름으로 같은 매장 해당 id 다 반환
    @Override
    public List<ResponseNameToIdsDto> getIds(String name) {
        List<ResponseNameToIdsDto> result = queryFactory
                .select(Projections.constructor(ResponseNameToIdsDto.class,
                        youtube.youtubeStore.id,
                        youtube.youtubeStore.id.concat("/hqdefault.jpg").prepend("https://i1.ytimg.com/vi/")))
                .from(youtube)
                .where(youtube.name.eq(name))
                .fetch();

        return result;
    }
}
