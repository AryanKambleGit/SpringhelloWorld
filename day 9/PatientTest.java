package com.codinghusttle.real.hospitalManagemnet;

import com.codinghusttle.real.hospitalManagemnet.Service.PatientService;
import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
import com.codinghusttle.real.hospitalManagemnet.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;


    @Test
    public void CheckPateint() {
        List<Patient> patientCheck = patientRepository.findAll();
        System.out.println(patientCheck);


        Patient p1 = new Patient();
        patientRepository.save(p1);


    }
//    @Test
//    public void CheckPatientBYID(){

    /// /        System.out.println("enter the data whos data neeeddeed");
    /// /        Scanner sc = new Scanner(System.in);
    /// /        Long id = sc.nextLong();
//       Patient patient =  patientService.getPateinById(1L );
//        System.out.println(patient);
//    }


//    @Test
//
//    public void checkPatientByName(){
//        Patient patient = patientRepository.findPatientByName("Aryan Kamble");
//        System.out.println(patient);
//    }
    @Test
    public void testTransactionMethod() {
        List<Patient> patientList = patientRepository.findByEmailOrBirthdate(
                "sneha.patil@example.com",
                LocalDate.of(2000, 9, 18)
        );

        for (Patient patient : patientList) {
            System.out.println(patient);
        }


    }


    @Test
    void testFindByEmail() {
        Patient patient = patientRepository.findByEmail("sneha.patil@example.com");
        System.out.println("Patient by Email: " + patient);
    }

    // 2. Find by Birthdate
    @Test
    void testFindByBirthdate() {
        List<Patient> patients = patientRepository.findByBirthdate(LocalDate.of(2000, 9, 18));
        patients.forEach(p -> System.out.println("Patient by Birthdate: " + p));
    }

    // 3. Find by Email OR Birthdate
    @Test
    void testFindByEmailOrBirthdate() {
        List<Patient> patients = patientRepository.findByEmailOrBirthdate(
                "sneha.patil@example.com",
                LocalDate.of(2000, 9, 18)
        );
        patients.forEach(p -> System.out.println("Patient by Email or Birthdate: " + p));
    }

    // 4. Find by BloodGroup
    @Test
    void testFindByBloodGroup() {
        List<Patient> patients = patientRepository.findByBloodGroup("O+");
        patients.forEach(p -> System.out.println("Patient by BloodGroup: " + p));
    }

    // 5. Find by Gender AND BloodGroup
    @Test
    void testFindByGenderAndBloodGroup() {
        List<Patient> patients = patientRepository.findByGenderAndBloodGroup("Female", "O+");
        patients.forEach(p -> System.out.println("Patient by Gender + BloodGroup: " + p));
    }

    // 6. Find by Name containing (case-insensitive)
    @Test
    void testFindByNameContainingIgnoreCase() {
        List<Patient> patients = patientRepository.findByNameContainingIgnoreCase("sharma");
        patients.forEach(p -> System.out.println("Patient containing name 'sharma': " + p));
    }

    // 7. Find by Birthdate Before
    @Test
    void testFindByBirthdateBefore() {
        List<Patient> patients = patientRepository.findByBirthdateBefore(LocalDate.of(2001, 1, 1));
        patients.forEach(p -> System.out.println("Patient born before 2001: " + p));
    }

    // 8. Find by Birthdate After
    @Test
    void testFindByBirthdateAfter() {
        List<Patient> patients = patientRepository.findByBirthdateAfter(LocalDate.of(2000, 1, 1));
        patients.forEach(p -> System.out.println("Patient born after 2000: " + p));
    }

    // 9. Find All Ordered by Name ASC
    @Test
    void testFindByOrderByNameAsc() {
        List<Patient> patients = patientRepository.findByOrderByNameAsc();
        patients.forEach(p -> System.out.println("Patient ordered by name: " + p));

    }
}