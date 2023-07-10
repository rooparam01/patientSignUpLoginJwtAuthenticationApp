package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient addNewPatient(Patient patient) {
       Patient savedPatient = patientRepository.save(patient);
        return savedPatient;
    }
}
