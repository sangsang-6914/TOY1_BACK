package com.sangsang.backend.jpa.manage.service;

import com.sangsang.backend.dto.UserDTO;
import com.sangsang.backend.jpa.entity.UserEntity;
import com.sangsang.backend.jpa.repository.UserJPARepository;
import com.sangsang.backend.jpa.service.UserService;
import com.sangsang.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userJPAService")
public class UserJPAService implements UserService {

    @Autowired
    UserJPARepository userJPARepository;

    @Override
    public UserDTO get(String s) {
        return null;
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

        // password 암호화 비교
        UserEntity entity = userJPARepository.findByIdAndPassword(dto.getId(), dto.getPassword());
        if (entity == null) {
            // 추후 에러 or 메시지 처리
            System.out.println("존재하지 않는 사용자");
        } else {
            return UserMapper.INSTANCE.entityToDto(entity);
        }

        return null;
    }

    @Override
    public boolean join(UserDTO dto) {
        return true;
    }
}
