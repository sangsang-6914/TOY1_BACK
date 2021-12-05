package com.sangsang.backend.user.service;

import com.sangsang.backend.common.service.CrudService;
import com.sangsang.backend.user.dto.UserDTO;

public interface UserService extends CrudService<UserDTO, String> {

    UserDTO login(UserDTO dto);

    boolean join(UserDTO dto);

}
