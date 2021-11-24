package com.sangsang.backend;

import com.sangsang.backend.common.Gender;
import com.sangsang.backend.dto.UserDTO;
import com.sangsang.backend.jpa.entity.UserEntity;
import com.sangsang.backend.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserMapperTest {
    @Test
    @DisplayName("DTO에서 Entity로 변환")
    void dtoToEntityTest() {
        final UserDTO userDTO = UserDTO.builder()
                .oid("AMDKDDD")
                .id("sangsang6914")
                .name("우상훈")
                .age(24)
                .gender(Gender.MAN)
                .build();

        final UserEntity entity = UserMapper.INSTANCE.dtoToEntity(userDTO);

        System.out.println(entity.getId());
        System.out.println(entity.getName());
    }
}
