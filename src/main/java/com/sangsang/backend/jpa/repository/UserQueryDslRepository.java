package com.sangsang.backend.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sangsang.backend.common.Gender;
import com.sangsang.backend.jpa.entity.QUserEntity;
import com.sangsang.backend.jpa.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserQueryDslRepository {
    private final JPAQueryFactory factory;

    // 추후 condition 형태로 변형 -> 동적쿼리로 작성
    // User -> 공통 Entity로 변경(Generic)
    // 2개의 qclass로 join test 추가
    public List<UserEntity> findAllByGender(Gender gender) {
        QUserEntity qUserEntity = QUserEntity.userEntity;

        List<UserEntity> list = factory
                .select(qUserEntity)
                .from(qUserEntity)
                .where(qUserEntity.gender.eq(gender))
                .fetch();

        return list;
    }
}
