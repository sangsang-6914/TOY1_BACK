package com.sangsang.backend.user.service.impl;

import com.sangsang.backend.user.dto.CustomUserDetails;
import com.sangsang.backend.user.dto.UserDTO;
import com.sangsang.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserDTO userDTO = Optional.ofNullable(userService.get(username))
                .orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));

       CustomUserDetails userDetails = new CustomUserDetails();
       userDetails.setId(userDTO.getId());
       userDetails.setPw(userDTO.getPassword());

       return userDetails;
    }
}
