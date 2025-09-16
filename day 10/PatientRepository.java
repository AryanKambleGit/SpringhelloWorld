package com.codinghusttle.real.hospitalManagemnet.repository;

import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
import com.codinghusttle.real.hospitalManagemnet.type.BloodGroup;
import com.codinghusttle.real.hospitalManagemnet.type.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Long> {




//
//    // 1. Find by exact email
//    Patient findByEmail(String email);
//
//    // 2. Find by exact birthdate
//    List<Patient> findByBirthdate(LocalDate birthdate);
//
//    // 3. Find by email OR birthdate
//    List<Patient> findByEmailOrBirthdate(String email, LocalDate birthdate);
//
//    // 4. Find all patients with a certain blood group
//    List<Patient> findByBloodGroup(String bloodGroup);
//
//    // 5. Find by gender and blood group
//    List<Patient> findByGenderAndBloodGroup(String gender, String bloodGroup);
//
//    // 6. Find by name containing keyword (like %name%)
//    List<Patient> findByNameContainingIgnoreCase(String name);
//
//    // 7. Find patients born before a date
//    List<Patient> findByBirthdateBefore(LocalDate date);
//
//    // 8. Find patients born after a date
//    List<Patient> findByBirthdateAfter(LocalDate date);
//
//    // 9. Find all patients ordered by name
//    List<Patient> findByOrderByNameAsc();




    /// Thisuper things are ok but QueryAnotation are also you can use

//    @Query ("select p from Patient p where p.bloodGroup = ?1")
//    List<Patient > findByBloodGroupQuery(@Param("bloodGroup")BloodGroup bloodGroup);

//    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
//    List<Patient> findByBloodGroupQuery(BloodGroup bloodGroup);

    // OR Named parameter (needs @Param)
    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroupQuery(@Param("bloodGroup") BloodGroup bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.birthdate > :date")
    List<Patient> findBornAfterDate(@Param("date") LocalDate date);

    @Query("SELECT p FROM Patient p WHERE p.birthdate < :date")
    List<Patient> findBornBeforeDate(@Param("date") LocalDate date);

    // 1. Find all patients with specific gender
    @Query("SELECT p FROM Patient p WHERE p.gender = :gender")
    List<Patient> findByGender(@Param("gender") Gender gender);

    // 2. Find all patients with specific blood group
    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    // 3. Patients created after a given timestamp
    @Query("SELECT p FROM Patient p WHERE p.createdAt > :dateTime")
    List<Patient> findByCreatedAtAfter(@Param("dateTime") LocalDateTime dateTime);

    // 4. Patients born between two dates
    @Query("SELECT p FROM Patient p WHERE p.birthdate BETWEEN :startDate AND :endDate")
    List<Patient> findByBirthdateBetween(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);

    // 5. Patients whose name starts with a given prefix
    @Query("SELECT p FROM Patient p WHERE p.name LIKE CONCAT(:prefix, '%')")
    List<Patient> findByNameStartingWith(@Param("prefix") String prefix);

    // 6. Patients whose name contains given keyword
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:keyword%")
    List<Patient> findByNameContaining(@Param("keyword") String keyword);

    // 7. Patients by exact email (unique check)
    @Query("SELECT p FROM Patient p WHERE p.email = :email")
    Optional<Patient> findByEmail(@Param("email") String email);

    // 8. Patients with a certain gender and blood group together
    @Query("SELECT p FROM Patient p WHERE p.gender = :gender AND p.bloodGroup = :bloodGroup")
    List<Patient> findByGenderAndBloodGroup(@Param("gender") Gender gender,
                                            @Param("bloodGroup") BloodGroup bloodGroup);

    // 9. Patients created before a given date
    @Query("SELECT p FROM Patient p WHERE p.createdAt < :dateTime")
    List<Patient> findByCreatedAtBefore(@Param("dateTime") LocalDateTime dateTime);

    // 10. Top 5 most recently created patients
    @Query("SELECT p FROM Patient p ORDER BY p.createdAt DESC")
    List<Patient> findTop5ByOrderByCreatedAtDesc(Pageable pageable);

}
