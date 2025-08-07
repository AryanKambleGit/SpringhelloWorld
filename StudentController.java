package com.codingshuttle.youtube.Learning.Rest.APIs.controller;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
   return      new StudentDto(20L,"This Is My HAbbit to Play with you","aryankamble41430@gmail.com");



    }
}
