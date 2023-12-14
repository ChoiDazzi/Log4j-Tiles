package kr.letech.study.springBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/v1/users/**").permitAll()
                .and()
                .formLogin()
                .usernameParameter("userId")
                .passwordParameter("userPw")
                .loginPage("/api/v1/login")
//                .loginProcessingUrl("/api/v1/login")
                .and()
                .headers().frameOptions().sameOrigin();
        return http.build();
    }
}
