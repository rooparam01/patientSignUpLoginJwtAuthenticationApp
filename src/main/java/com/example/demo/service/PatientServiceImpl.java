package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient addNewPatient(Patient patient) {
        patient.setRole("ROLE_PATIENT");
       Patient savedPatient = patientRepository.save(patient);
        return savedPatient;
    }

    @Override
    public Patient getPatientDetailsByEmail(String name) {
       Optional<Patient> opt = patientRepository.findByEmail(name);
       if(opt.isEmpty()){
           throw new RuntimeException("Invalid user name");
       }else{
           Patient patient = opt.get();
           return patient;
       }
    }
}
