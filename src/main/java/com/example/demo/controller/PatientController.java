package com.example.demo.controller;

import com.example.demo.appConfiguration.JwtTokenValidatorFilter;
import com.example.demo.entity.*;
import com.example.demo.service.PatientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @SecurityRequirement(name = "demo-openapi")
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

    @SecurityRequirement(name = "demo-openapi")
    @PutMapping("/patients")
    public ResponseEntity<Patient> updatePatient(@Valid @RequestBody Patient patient){
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        if(!JwtTokenValidatorFilter.getUsername.equals(patient.getEmail())){
            throw new RuntimeException("Unauthorized trasation");
        }
        Patient savedPatient = patientService.updatePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.OK);
    }

    @SecurityRequirement(name = "demo-openapi")
    @DeleteMapping("/patients/{email}")
    public ResponseEntity<String> deletePatient(@RequestParam String email){
        if(!JwtTokenValidatorFilter.getUsername.equals(email)){
            throw new RuntimeException("Unauthorized trasation");
        }
        String message = patientService.deletePatients(email);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @SecurityRequirement(name = "demo-openapi")
    @GetMapping("/patients")
    public ResponseEntity<Patient> getPatient(){
        Patient patient = patientService.getPatientDetailsByEmail(JwtTokenValidatorFilter.getUsername);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }



    @SecurityRequirement(name = "demo-openapi")
    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInPatientDetailsHandler(Authentication auth){

        System.out.println(auth);

        Patient patient= patientService.getPatientDetailsByEmail(auth.getName());

        return new ResponseEntity<>(patient.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }



}
