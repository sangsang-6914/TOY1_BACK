package com.sangsang.backend.common.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sangsang.backend.common.search.SearchParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public abstract class AbstractQueryDslRepository<E, QE> {
    protected final JPAQueryFactory factory;

    

}
