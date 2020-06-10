package com.gchsj.h2jpav1.data;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gchsj.h2jpav1.data.QCity.city;

@Repository
public class CityRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public CityRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(City.class);
        this.queryFactory = jpaQueryFactory;
    }

    public List<City> findByName(String name) {
//        query.from(qCity).where(qCity.name.eq("Bratislava")).distinct();
        return queryFactory.selectFrom(city).where(city.name.eq(name)).fetch();
//        query2.from(qCity).where(qCity.name.endsWith("est").and(qCity.population.lt(1800000)));
//        return queryFactory
//                .selectFrom(academy)
//                .where(academy.name.eq(name))
//                .fetch();
    }
}
