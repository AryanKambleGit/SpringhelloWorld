package com.codingshuttle.youtube.Learning.Rest.APIs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
public class addStudentRequestDto {
   private Long age;
   private String name;
   private String email;
}
