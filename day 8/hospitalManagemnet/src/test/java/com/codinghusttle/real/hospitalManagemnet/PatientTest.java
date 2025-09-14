//package com.codinghusttle.real.hospitalManagemnet;
//
//import com.codinghusttle.real.hospitalManagemnet.Service.PatientService;
//import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
//import com.codinghusttle.real.hospitalManagemnet.repository.PatientRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Scanner;
//
//@SpringBootTest
//public class PatientTest {
//
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @Autowired
//    private PatientService patientService;
//
//
//    @Test
//    public void CheckPateint(){
//        List<Patient> patientCheck = patientRepository.findAll();
//        System.out.println(patientCheck);
//
//
//        Patient p1 = new Patient();
//        patientRepository.save(p1);
//
//
//
//    }
//    @Test
//    public void CheckPatientBYID(){
////        System.out.println("enter the data whos data neeeddeed");
////        Scanner sc = new Scanner(System.in);
////        Long id = sc.nextLong();
//       Patient patient =  patientService.getPateinById(1L );
//        System.out.println(patient);
//    }
//}
