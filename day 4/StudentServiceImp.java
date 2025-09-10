package com.codingshuttle.youtube.Learning.Rest.APIs.service.imp;

import com.codingshuttle.youtube.Learning.Rest.APIs.dto.StudentDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.dto.addStudentRequestDto;
import com.codingshuttle.youtube.Learning.Rest.APIs.entity.Student;
import com.codingshuttle.youtube.Learning.Rest.APIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public void deleteStudentByid(Long id) {
        if (!studentRepository.existsById(id)){
          throw new IllegalArgumentException("Student with this  not existed "+ id);

        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentByid(Long id, addStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        modelMapper.map(addStudentRequestDto, student);
        student= studentRepository.save(student);
         return  modelMapper.map(student, StudentDto.class);



    }

    @Override
    public StudentDto updateStudentPartially(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        updates.forEach((field, value) -> {
            switch (field ){
                case "name" : student.setName((String) value);
                break;
                case "email" : student.setEmail((String) value);
                break;
                default: throw new IllegalArgumentException("firld no supppostred");

            }
        });

       Student saveStudent= studentRepository.save(student);
        return  modelMapper.map(saveStudent, StudentDto.class);
    }


}