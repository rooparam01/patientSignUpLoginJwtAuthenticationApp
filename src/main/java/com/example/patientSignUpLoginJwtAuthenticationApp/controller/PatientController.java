package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/hello")
    public String testHandler() {
        return "Welcome to Spring Security";
    }
    @PostMapping("/patients")
    public ResponseEntity<Patient> addNewPatient(@Valid @RequestBody Patient patient){
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        Patient savedPatient = patientService.addNewPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }





}
