package com.gchsj.querydslv4.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gchsj.querydslv4.domain.QAcademy.academy;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public AcademyRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Academy.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Academy> findByName(String name) {
        return jpaQueryFactory
                .selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }
}
