package bkk.waytoeat.domain;

import bkk.waytoeat.domain.enumClass.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StoreTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Rollback(value = true)
    public void setStoreTest() {
        Store store = new Store();
        store.setId("idididid");
        store.setName("가게1");
        store.setPhone("010-1111-1111");
        store.setLocation("도로명주소");
        store.setLatitude(123.1414112);
        store.setLongitude(75.1212);
        store.setNaverRating(4.3);
        store.setKakaoRating(3.7);
        store.setSelfRating(4.8);
        store.setMenuImage("abdcatet-dajt.html");
        store.setReservation(true);
        store.setPackaging(false);
        store.setDetail("반려견 출입 금지");
        store.setCategory(Category.KOREAN);

        em.persist(store);
    }
}