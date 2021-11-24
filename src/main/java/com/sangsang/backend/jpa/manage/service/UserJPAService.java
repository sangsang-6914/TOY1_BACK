package com.sangsang.backend.jpa.manage.service;

import com.sangsang.backend.dto.UserDTO;
import com.sangsang.backend.jpa.entity.UserEntity;
import com.sangsang.backend.jpa.repository.UserJPARepository;
import com.sangsang.backend.jpa.service.UserService;
import com.sangsang.backend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userJPAService")
@RequiredArgsConstructor
public class UserJPAService implements UserService {

    @Autowired
    UserJPARepository userJPARepository;

    private final UserMapper userMapper;

    @Override
    public UserDTO get(String id) {
        UserEntity entity = userJPARepository.getById(id);
        return userMapper.entityToDto(entity);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO delete(String s) {
        return null;
    }

    @Override
    public List<UserDTO> search() {
        return null;
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
        userJPARepository.save(entity);

        return true;
    }
}
