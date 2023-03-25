package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassworEncoder {
    @Bean
    public BCryptPasswordEncoder getPaswwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
