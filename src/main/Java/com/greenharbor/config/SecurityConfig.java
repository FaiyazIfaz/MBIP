
package com.greenharbor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.greenharbor.service.UserService;

import jakarta.annotation.Resource.AuthenticationType;

@Configuration
@EnableWebMvc
public class SecurityConfig<HttpSecurity, PasswordEncoder> extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    protected void configure(AuthenticationType auth) throws Exception {
        auth.UserService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ((User) http).authorizeRequests()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login"
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")  // specify logout URL
                .permitAll();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
