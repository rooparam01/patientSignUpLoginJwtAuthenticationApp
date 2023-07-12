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

    @Override
    public Patient updatePatient(Patient patient) {
        Optional<Patient> opt = patientRepository.findById(patient.getId());
        if(opt.isEmpty()){
            throw new RuntimeException("Invalid user Id");
        }else{
            Patient patientAlreadyDetails = opt.get();
            if(!patientAlreadyDetails.getEmail().equals(patient.getEmail())){
                throw new RuntimeException("You are not allow to change email so please provide correct email or Id");
            }
            patientAlreadyDetails.setName(patient.getName());
            patientAlreadyDetails.setMobile(patient.getMobile());
            patientAlreadyDetails.setPassword(patient.getPassword());
            patientAlreadyDetails.setAddress(patient.getAddress());
            patientAlreadyDetails.setPincode(patient.getPincode());
            patientRepository.save(patientAlreadyDetails);
            return patientAlreadyDetails;
        }
    }

    @Override
    public String deletePatients(String email) {
       Optional<Patient> optionalPatient = patientRepository.findByEmail(email);
        if(optionalPatient.isEmpty()){
            throw new RuntimeException("Invalid email id");
        }
        Patient patient = optionalPatient.get();
        patientRepository.delete(patient);
        return "Deleted successfully";
    }
}
