package com.example.Learning.Spring.Boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {

    @GetMapping("/")
    public String hello(){
        return "hello poo";
    }

}
