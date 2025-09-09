package com.codingshuttle.youtube.Learning.Rest.APIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends addStudentRequestDto {
    private Long id;
    private Long age;
    private String name;
    private String email;
}