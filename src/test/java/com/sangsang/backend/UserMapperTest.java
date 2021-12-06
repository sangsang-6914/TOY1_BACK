package com.sangsang.backend;

import com.sangsang.backend.common.constant.Gender;
import com.sangsang.backend.common.search.SearchParam;
import com.sangsang.backend.user.dto.UserDTO;
import com.sangsang.backend.user.jpa.entity.UserEntity;
import com.sangsang.backend.user.service.UserService;
import com.sangsang.backend.user.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private String userOid = "5XYQ15SQIAS";

    @Test
    @DisplayName("DTO에서 Entity로 변환")
    void dtoToEntityTest() {
        final UserDTO userDTO = UserDTO.builder()
                .oid(userOid)
                .userId("sangsang6914")
                .name("우상훈")
                .age(24)
                .gender(Gender.M)
                .build();

        final UserEntity entity = userMapper.dtoToEntity(userDTO);
        // UserDTO resultDto = userService.login(userDTO);
    }

    @Test
    @DisplayName("JPA CRUD Test")
    void jpaCreateTest() {
        final UserDTO userDTO = UserDTO.builder()
                .oid(userOid)
                .userId("sangsang691422")
                .password("AKEIWLLKSISKSLAKAL")
                .name("김상훈")
                .age(44)
                .gender(Gender.W)
                .build();

        // 가입
        userService.join(userDTO);
    }

    @Test
    @DisplayName("JPA Read Test")
    void jpaReadTest() {
        UserDTO userDto = userService.get(userOid);

        System.out.println(userDto.getUserId());
        System.out.println(userDto.getName());
    }

    @Test
    @DisplayName("JPA Delete Test")
    void jpaDeleteTest() {
        UserDTO userDTO = userService.delete(userOid);

        System.out.println(userDTO.getName());
        System.out.println(userDTO.getUserId());
    }

    @Test
    @DisplayName("JPA Search Test")
    void jpaSearchTest() {

        SearchParam searchParam = new SearchParam();
        List<UserDTO> list = userService.list(searchParam);

        for (UserDTO dto : list) {
            System.out.println(dto.getUserId());
            System.out.println(dto.getGender());
        }

    }

    @Test
    @DisplayName("EncryptTest")
    void EncryptTest() {
        String pwd = "asdf123412#";

        String encrypt = bCryptPasswordEncoder.encode(pwd);
        System.out.println(encrypt);

        if (bCryptPasswordEncoder.matches(pwd, encrypt)) {
            System.out.println("동일한 패스워드!!");
        } else {
            System.out.println("다른 패스워드!!");
        }
    }
}
