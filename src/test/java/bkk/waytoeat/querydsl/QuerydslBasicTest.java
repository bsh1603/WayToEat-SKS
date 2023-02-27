package bkk.waytoeat.querydsl;

import bkk.waytoeat.domain.querydsltest.Hello;
import bkk.waytoeat.domain.querydsltest.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static bkk.waytoeat.domain.querydsltest.QHello.*;
import static bkk.waytoeat.domain.querydsltest.QHello.hello;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Test
    void 기본테스트() {
        Hello hello = new Hello();
        em.persist(hello);

        queryFactory = new JPAQueryFactory(em);

        Hello result = queryFactory
                .selectFrom(QHello.hello)
                .fetchOne();

        assertThat(result).isEqualTo(hello);
        assertThat(result.getId()).isEqualTo(hello.getId());
    }
}
