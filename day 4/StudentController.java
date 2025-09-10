package com.codingshuttle.youtube.Learning.Rest.APIs.controller;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.dto.addStudentRequestDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.entity.Student;
import com.codingshuttle.youtube.Learning.Rest.APIs.service.imp.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("students")
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

//    @GetMapping
//    public List<StudentDto> studentDtoList(){
//        return studentService.getAllStudent();
//    }
//
//    @GetMapping("/{id}")
//    public StudentDto studentDtoListById(@PathVariable Long id){
//        return studentService.getAllStudentByid(id);
//    }
//
//    @GetMapping("/students/{id}/{name}")
//    public String studentbyNameAndId(@PathVariable Long id, @PathVariable String name){
//        return "ID is " + id + " String is " + name;
//    }


    @GetMapping
    public ResponseEntity< List<StudentDto>> studentDtoList(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> studentDtoListById(@PathVariable Long id){
//        return studentService.getAllStudentByid(id);
        return ResponseEntity.ok(studentService.getAllStudentByid(id));

    }

    @GetMapping("/students/{id}/{name}")
    public String studentbyNameAndId(@PathVariable Long id, @PathVariable String name){
        return "ID is " + id + " String is " + name;
    }

    @PostMapping
    public ResponseEntity<addStudentRequestDto> createNewStudent(@RequestBody @Valid addStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED ).body(studentService.createNewStudent(addStudentRequestDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentByid(@PathVariable Long id ){
         studentService.deleteStudentByid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentByid(@PathVariable Long id , @RequestBody @Valid addStudentRequestDto addStudentRequestDto){
//      StudentDto s = studentService.updateStudentByid(id); wrong iguess

        return ResponseEntity.ok(studentService.updateStudentByid(id, addStudentRequestDto));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentPartially(@PathVariable Long id , @RequestBody @Valid Map<String , Object > update ){
        return ResponseEntity.ok(studentService.updateStudentPartially(id,update));
    }




}


