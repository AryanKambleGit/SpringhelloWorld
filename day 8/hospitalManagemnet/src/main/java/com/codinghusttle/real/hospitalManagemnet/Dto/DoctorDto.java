package com.codinghusttle.real.hospitalManagemnet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long doctId;
    private String name;
    private String email;
    private String speciality;
}
