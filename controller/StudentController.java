package com.codingshuttle.youtube.Learning.Rest.APIs.controller;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.entity.Student;
import com.codingshuttle.youtube.Learning.Rest.APIs.repository.StudnetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

//    @GetMapping("/student")
//    public StudentDto getStudent(){
//   return      new StudentDto(20L,"This Is My HAbbit to Play with you","aryankamble41430@gmail.com");
//
//    }
//    @GetMapping("/student/{id}")
//    public StudentDto getStudentById(){
//        return new StudentDto(4L , "aryan","bantai@gmail.com");
//    }
//
    private final StudnetRepository studnetRepository;

    public StudentController(StudnetRepository studnetRepository){
        this.studnetRepository = studnetRepository;

    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return  studnetRepository.findAll();
    }


}
