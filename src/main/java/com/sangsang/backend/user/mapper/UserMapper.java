package com.sangsang.backend.user.mapper;

import com.sangsang.backend.common.mapper.ObjectMapper;
import com.sangsang.backend.user.dto.UserDTO;
import com.sangsang.backend.user.jpa.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends ObjectMapper<UserDTO, UserEntity> {
}
