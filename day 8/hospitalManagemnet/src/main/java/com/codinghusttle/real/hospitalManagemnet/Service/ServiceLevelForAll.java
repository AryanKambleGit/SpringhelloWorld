package com.codinghusttle.real.hospitalManagemnet.Service;

import org.springframework.stereotype.Service;
import com.codinghusttle.real.hospitalManagemnet.Dto.DoctorDto;

import java.util.List;



public interface ServiceLevelForAll {


     DoctorDto getDoctorByid(Long id);

    List<DoctorDto> getAllDoctors();

    List<DoctorDto> getDoctorBySpeciality(String speciality);

    List<DoctorDto> getDoctorByName(String name);
}
