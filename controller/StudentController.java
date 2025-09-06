package com.codingshuttle.youtube.Learning.Rest.APIs.controller;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.entity.Student;
import com.codingshuttle.youtube.Learning.Rest.APIs.repository.StudentRepository;
import com.codingshuttle.youtube.Learning.Rest.APIs.service.imp.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    // Direct without any persistance layer

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


    // Direct Accessing using presntation and persistatnce layer

//    private final StudnetRepository studnetRepository;
//
//    public StudentController(StudnetRepository studnetRepository) {
//        this.studnetRepository = studnetRepository;
//    }
//    @GetMapping("/student")
//    public List<Student> getStudent(){
//        return studnetRepository.findAll();
//
//    }


    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping("/students")
    public List<StudentDto> studentDtoList(){
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public StudentDto studentDtoListById(@PathVariable Long id){
        return studentService.getAllStudentByid(id);
    }

    @GetMapping("/students/{id}/{name}")
    public String studentbyNameAndId(@PathVariable Long id, @PathVariable String name){
        return "ID is " + id + " String is " + name;
    }
}


