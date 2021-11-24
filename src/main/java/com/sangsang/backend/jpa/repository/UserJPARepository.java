package com.sangsang.backend.jpa.repository;

import com.sangsang.backend.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, String> {

    UserEntity findByIdAndPassword(String id, String password);

}
