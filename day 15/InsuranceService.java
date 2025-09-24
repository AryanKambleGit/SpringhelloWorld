package com.codinghusttle.real.hospitalManagemnet.Service;

import com.codinghusttle.real.hospitalManagemnet.entity.Insurance;
import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
import com.codinghusttle.real.hospitalManagemnet.repository.InsuranceRepository;
import com.codinghusttle.real.hospitalManagemnet.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient   AssignInsuranceToPatient (Insurance insurance , Long id){
      Patient patient = patientRepository.findById(id)
              .orElseThrow(()->new EntityNotFoundException("No found with this id "));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // biderectional mappping

        return patient;


    }


}
