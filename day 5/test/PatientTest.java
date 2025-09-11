package com.codinghusttle.real.hospitalManagemnet;

import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
import com.codinghusttle.real.hospitalManagemnet.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void CheckPateint(){
        List<Patient> patientCheck = patientRepository.findAll();
        System.out.println(patientCheck);

    }
}
