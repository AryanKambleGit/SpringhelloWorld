package com.codinghusttle.real.hospitalManagemnet.Service;

//
//import com.codinghusttle.real.hospitalManagemnet.Dto.DoctorDto;
//import com.codinghusttle.real.hospitalManagemnet.entity.Doctors;
import com.codinghusttle.real.hospitalManagemnet.Dto.PatientDto;
import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
import com.codinghusttle.real.hospitalManagemnet.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService implements ServiceLevelForAll{

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class)) // ✅ map each Patient → PatientDto
                .toList();
    }


    //Before managing transacion Getitng 2 output means 2 times it check but senario after transaction is diff
//    public Patient getPateinById(Long id ){
//      Patient p1 =  patientRepository.findById(id).orElseThrow();
//        Patient p2 =  patientRepository.findById(id).orElseThrow();
//        return p1;
//
//    }


    // After Using transaction method

//    @Transactional
//    public Patient getPateinById(Long id ) {
//    }

//        Patient p1 = patientRepository.findById(id).orElseThrow();
//
//        Patient p2 = patientRepository.findById(id).orElseThrow();

     //It use to equal both the object cause it is in the persistent layer before storing to db

//        System.out.println(p1 == p2 );
//
//        p1.setName("Alok");
//        p1.setEmail("AlokTheOg@gmail.com");
//
//        return p2;








}
