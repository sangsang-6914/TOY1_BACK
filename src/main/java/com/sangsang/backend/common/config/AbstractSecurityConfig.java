package com.sangsang.backend.common.config;

import com.sangsang.backend.security.handler.CustomFailureHandler;
import com.sangsang.backend.security.handler.CustomSuccessHandler;
import com.sangsang.backend.security.provider.CustomAuthProvider;
import com.sangsang.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public abstract class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected UserService userService;

    protected AuthenticationProvider getAuthenticationProvider() {
        return new CustomAuthProvider(new BCryptPasswordEncoder(), userService);
    }

    protected AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
        return new CustomSuccessHandler();
    }

    protected AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return new CustomFailureHandler();
    }

    protected String[] addIgnoringUrlArray() { return new String[] {}; }

    protected String[] getIgnoringUrlArray() {

        String [] defaultArray = new String[] {
            "/resources/**", "/h2-console/**"
        };
        String [] addArray = addIgnoringUrlArray();

        return concatArray(defaultArray, addArray);

    }

    protected String[] concatArray(String[] defaultArray, String[] addArray) {

        if (defaultArray == null && addArray == null) {
            return new String[] {};
        }

        if (defaultArray.length < 1 && addArray.length < 1) {
            return addArray;
        }

        if (defaultArray.length < 1 || defaultArray == null) {
            return addArray;
        }

        if (addArray.length < 1 || addArray == null) {
            return defaultArray;
        }

        int defaultLength = defaultArray.length;
        int addLength = addArray.length;

        String [] resultArray = new String[defaultLength + addLength];

        System.arraycopy(defaultArray, 0, resultArray, 0, defaultLength);
        System.arraycopy(addArray, 0, resultArray, defaultLength, addLength );

        return resultArray;
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(getIgnoringUrlArray());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //        .antMatchers("/main/**").permitAll() // main/ 경로 모두 허용
                .antMatchers("/user/**").authenticated();

        http.csrf().disable();

        http.formLogin()
                // .loginPage("/login") // 지정 안할 시 security default page
                .loginProcessingUrl("/loginProcess")
                .usernameParameter("userid")
                .passwordParameter("pw")
                .successHandler(getAuthenticationSuccessHandler())
                .failureHandler(getAuthenticationFailureHandler());

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.authenticationProvider(getAuthenticationProvider());

    }

}
