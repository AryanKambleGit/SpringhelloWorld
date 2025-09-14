package com.codinghusttle.real.hospitalManagemnet.repository;

import com.codinghusttle.real.hospitalManagemnet.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctors, Long> {

    List<Doctors> findDoctorBySpeciality(String speciality);

    List<Doctors> findDoctorByName (String name);





}
