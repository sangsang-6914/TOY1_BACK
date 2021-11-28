package com.sangsang.backend.jpa.manage.service;

import com.sangsang.backend.common.Gender;
import com.sangsang.backend.dto.UserDTO;
import com.sangsang.backend.jpa.entity.UserEntity;
import com.sangsang.backend.jpa.repository.UserJPARepository;
import com.sangsang.backend.jpa.repository.UserQueryDslRepository;
import com.sangsang.backend.jpa.service.UserService;
import com.sangsang.backend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userJPAService")
@RequiredArgsConstructor
public class UserJPAService implements UserService {

    @Autowired
    UserJPARepository userJPARepository;

    @Autowired
    UserQueryDslRepository userQueryDslRepository;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO get(String id) {
        UserEntity entity = userJPARepository.getById(id);
        if (entity == null) {
            System.out.println("사용자 존재하지 않음");
            return null;
        }
        return userMapper.entityToDto(entity);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    @Transactional
    public UserDTO delete(String id) {
        UserDTO dto = userMapper.entityToDto(userJPARepository.getById(id));
        userJPARepository.deleteById(id);

        return dto;
    }

    @Override
    public List<UserDTO> search() {

        Gender gender = Gender.M;

        List<UserEntity> entityList = userQueryDslRepository.findAllByGender(gender);

        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity entity : entityList) {
            dtoList.add(userMapper.entityToDto(entity));
        }

        return dtoList;

    }

    @Override
    public UserDTO login(UserDTO dto) {

        /*
        // password 암호화 비교
        UserEntity entity = userJPARepository.findByIdAndPassword(dto.getId(), dto.getPassword());
        if (entity == null) {
            // 추후 에러 or 메시지 처리
            System.out.println("존재하지 않는 사용자");
        } else {
            return userMapper.entityToDto(entity);
        }
         */

        UserEntity entity = userMapper.dtoToEntity(dto);

        return userMapper.entityToDto(entity);
    }

    @Override
    public boolean join(UserDTO dto) {
        UserEntity entity = userMapper.dtoToEntity(dto);
        try {
            userJPARepository.save(entity);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
