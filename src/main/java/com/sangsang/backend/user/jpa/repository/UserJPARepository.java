package com.sangsang.backend.user.jpa.repository;

import com.sangsang.backend.user.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {

    UserEntity findByUserIdAndPassword(String userId, String password);

    UserEntity findByUserId(String userId);

}
