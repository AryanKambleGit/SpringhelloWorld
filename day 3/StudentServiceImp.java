package com.codingshuttle.youtube.Learning.Rest.APIs.service.imp;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.dto.addStudentRequestDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.entity.Student;
import com.codingshuttle.youtube.Learning.Rest.APIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map( student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getAllStudentByid(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return modelMapper.map(student, StudentDto.class);
    }



    @Override
    public addStudentRequestDto createNewStudent(addStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map( addStudentRequestDto , Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }


}