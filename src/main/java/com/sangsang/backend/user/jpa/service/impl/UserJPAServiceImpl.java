package com.sangsang.backend.user.jpa.service.impl;

import com.sangsang.backend.common.constant.Gender;
import com.sangsang.backend.common.search.PageResult;
import com.sangsang.backend.common.search.SearchParam;
import com.sangsang.backend.common.service.AbstractJPAManageService;
import com.sangsang.backend.user.dto.UserDTO;
import com.sangsang.backend.user.jpa.repository.UserJPARepository;
import com.sangsang.backend.user.jpa.entity.UserEntity;
import com.sangsang.backend.user.jpa.repository.UserQueryDslRepository;
import com.sangsang.backend.user.service.UserService;
import com.sangsang.backend.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userJPAServiceImpl")
@RequiredArgsConstructor
public class UserJPAServiceImpl extends AbstractJPAManageService<UserEntity, UserDTO, String> implements UserService {

    private final UserJPARepository userJPARepository;
    private final UserQueryDslRepository userQueryDslRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO get(String id) {
        UserEntity entity = userJPARepository.findByUserId(id);

        if (entity == null) {
            System.out.println("조회된 사용자가 없습니다.");
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
    public List<UserDTO> list(SearchParam param) {

        Gender gender = Gender.M;

        List<UserEntity> entityList = userQueryDslRepository.findAllByGender(gender);

        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity entity : entityList) {
            dtoList.add(userMapper.entityToDto(entity));
        }

        return dtoList;

    }

    @Override
    public PageResult<UserDTO> listWithPage(SearchParam param) {
        return null;
    }

    @Override
    public UserDTO login(UserDTO dto) {

        /*
        // password 암호화 비교
        UserEntity entity = userJPARepository.findByUserIdAndPassword(dto.getUserId(), dto.getPassword());
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
    public UserDTO add(UserDTO dto) {
        return null;
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
