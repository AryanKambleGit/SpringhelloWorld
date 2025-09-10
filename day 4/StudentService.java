package com.codingshuttle.youtube.Learning.Rest.APIs.service.imp;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.dto.addStudentRequestDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getAllStudentByid(Long id);

    addStudentRequestDto createNewStudent(addStudentRequestDto addStudentRequestDto);


    void deleteStudentByid(Long id);

    StudentDto updateStudentByid(Long id, addStudentRequestDto addStudentRequestDto);

    StudentDto updateStudentPartially(Long id, Map<String, Object> update);
}