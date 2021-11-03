package com.example.lab2.configuration;

import com.example.lab2.entity.Music;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    public Music getMusic() {
        return new Music();
    }
}
