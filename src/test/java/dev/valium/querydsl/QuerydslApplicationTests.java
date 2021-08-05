package dev.valium.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.valium.querydsl.entity.Hello;
import dev.valium.querydsl.entity.QHello;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class QuerydslApplicationTests {

    @Autowired private EntityManager em;

    @Test
    void contextLoads() {
    }

    @Test
    public void queryDslTst() throws Exception {
        // given
        Hello h = new Hello();
        em.persist(h);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QHello qHello = QHello.hello;

        // when
        Hello result = query
                .selectFrom(qHello)
                .fetchOne();

        // then
        Assertions.assertThat(result).isEqualTo(h);
    }
}
