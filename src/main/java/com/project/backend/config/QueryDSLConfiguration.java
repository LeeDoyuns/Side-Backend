package com.project.backend.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QueryDSLConfiguration {

    private final EntityManager em;

    @Bean
    public JPAQueryFactory factory(EntityManager em){
        return new JPAQueryFactory(em);
    }
}
