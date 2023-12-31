package com.example.demo.service;

import com.example.demo.entity.Patient;

public interface PatientService {
    public Patient addNewPatient(Patient patient);

    public Patient getPatientDetailsByEmail(String name);

    public Patient updatePatient(Patient patient);

    public String deletePatients(String email);
}
