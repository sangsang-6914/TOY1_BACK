package com.sangsang.backend;

import com.sangsang.backend.common.Gender;
import com.sangsang.backend.dto.UserDTO;
import com.sangsang.backend.jpa.entity.UserEntity;
import com.sangsang.backend.jpa.service.UserService;
import com.sangsang.backend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("DTO에서 Entity로 변환")
    void dtoToEntityTest() {
        final UserDTO userDTO = UserDTO.builder()
                .oid("AMDKDDD")
                .id("sangsang6914")
                .name("우상훈")
                .age(24)
                .gender(Gender.M)
                .build();

        final UserEntity entity = userMapper.dtoToEntity(userDTO);
        // UserDTO resultDto = userService.login(userDTO);
    }

    @Test
    @DisplayName("JPA CRUD Test")
    void jpaCrudTest() {
        final UserDTO userDTO = UserDTO.builder()
                .oid("AXKO133KMMM")
                .id("sangsang691422")
                .name("김상훈")
                .age(44)
                .gender(Gender.W)
                .build();

        // 가입
        userService.join(userDTO);

        // 조회
        UserDTO dtoFromDB = userService.get(userDTO.getOid());
        System.out.println(dtoFromDB.getId());
    }
}
