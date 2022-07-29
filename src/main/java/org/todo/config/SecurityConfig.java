package org.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 우선 disable로 설정하고 추후 csrf 토큰 사용하는 걸로 디벨롭
        httpSecurity.csrf().disable();  // csrf 보호를 해제한다. csrf 보호 : get 요청을 제외한 Post, Patch, Delete 요청으로부터 보호한다.
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 디폴트인 세션, 쿠키 생성 허용 -> 불허
                .and()
                .
    }

}
