package com.sangsang.backend.user.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sangsang.backend.common.constant.Gender;
import com.sangsang.backend.common.jpa.repository.AbstractQueryDslRepository;
import com.sangsang.backend.user.jpa.entity.QUserEntity;
import com.sangsang.backend.user.jpa.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserQueryDslRepository extends AbstractQueryDslRepository<UserEntity, QUserEntity> {

    public UserQueryDslRepository(JPAQueryFactory factory) {
        super(factory);
    }
    // 추후 condition 형태로 변형 -> 동적쿼리로 작성
    // Entity마다 1개의 QueryDslRepository를 가져야함
    // 2개의 qclass로 join test 추가
    // 동적쿼리 만들 시 Specification처럼 SearchParam 하나 가지고는 처리할 수 없음
    // booleanBuilder를 통해 하나하나 가지고 처리해야함.. 비효율적
    public List<UserEntity> findAllByGender(Gender gender) {
        QUserEntity qUserEntity = QUserEntity.userEntity;

        List<UserEntity> list = factory.selectFrom(qUserEntity)
                .where(qUserEntity.gender.eq(gender))
                .fetch();

        return list;
    }
}
