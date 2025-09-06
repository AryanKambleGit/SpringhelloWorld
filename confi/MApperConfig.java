package com.codingshuttle.youtube.Learning.Rest.APIs.confi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MApperConfig {
    @Bean
    public ModelMapper maodelMapper(){
        return new ModelMapper();

    }
}
