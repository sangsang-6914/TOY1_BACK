package com.sangsang.backend.mapper;

import com.sangsang.backend.common.mapper.ObjectMapper;
import com.sangsang.backend.dto.UserDTO;
import com.sangsang.backend.jpa.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends ObjectMapper<UserDTO, UserEntity> {
}
