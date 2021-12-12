package com.sangsang.backend.security.provider;

import com.sangsang.backend.user.dto.CustomUserDetails;
import com.sangsang.backend.user.dto.UserDTO;
import com.sangsang.backend.user.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    public CustomAuthProvider(@Lazy PasswordEncoder passwordEncoder, @Lazy UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public CustomAuthProvider() {

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String pwd = (String)authentication.getCredentials();

        UserDTO user = userService.get(id);

        if (!passwordEncoder.matches(pwd, user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }

        return new UsernamePasswordAuthenticationToken(id, pwd, null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
