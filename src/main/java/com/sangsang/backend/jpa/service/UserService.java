package com.sangsang.backend.jpa.service;

import com.sangsang.backend.common.service.CrudService;
import com.sangsang.backend.dto.UserDTO;

public interface UserService extends CrudService<UserDTO, String> {

    UserDTO login(UserDTO dto);

    boolean join(UserDTO dto);

}
