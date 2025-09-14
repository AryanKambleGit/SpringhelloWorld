package com.codinghusttle.real.hospitalManagemnet.confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



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


