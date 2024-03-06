package com.sachin.assessmentspringboot.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class WebAPP {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
