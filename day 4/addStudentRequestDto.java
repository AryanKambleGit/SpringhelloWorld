package com.codingshuttle.youtube.Learning.Rest.APIs.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
public class addStudentRequestDto {


   @NotNull(message = "age is required")
   @Min(value = 5, message = "age must be at least 5")
   @Max(value = 100, message = "age must not be greater than 100")
   private Long age;

   @NotBlank
   @Size (min = 3 , max = 100 , message = "name should be of 3 to 100 character ")
   private String name;

   @Email
   @NotBlank( message = "email, toh required ")
   private String email;
}
