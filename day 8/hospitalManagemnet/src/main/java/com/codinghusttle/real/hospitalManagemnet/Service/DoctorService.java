package com.codinghusttle.real.hospitalManagemnet.Service;

import com.codinghusttle.real.hospitalManagemnet.entity.Doctors;
import com.codinghusttle.real.hospitalManagemnet.repository.DoctorRepo;
import lombok.AllArgsConstructor;
import com.codinghusttle.real.hospitalManagemnet.Dto.DoctorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService implements ServiceLevelForAll {

   private final DoctorRepo doctorRepo;
   private final ModelMapper modelMapper;



    @Override
    public DoctorDto getDoctorByid(Long id){
        Doctors doctors = doctorRepo.getReferenceById(id);
        return modelMapper.map(doctors, DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctors> doctors = doctorRepo.findAll();
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class)) // ✅ correct
                .toList();
    }

    @Override
    public List<DoctorDto> getDoctorBySpeciality(String speciality) {
        List<Doctors> doctors = doctorRepo.findDoctorBySpeciality(speciality);
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                .toList();
    }

    @Override
    public List<DoctorDto> getDoctorByName(String name) {
        List<Doctors> doctors = doctorRepo.findDoctorByName(name);
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                .toList();
    }

}

//    @Override
//    public List<DoctorDto> getDoctorByName() {
//        List< Doctors> doctors = doctorRepo.findDoctorByName(name);
//        return  doctors.stream().map(doctors1 ->
//                modelMapper.map(doctors,DoctorDto.class)).toList();
//
//
//    }





