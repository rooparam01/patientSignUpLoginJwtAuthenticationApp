package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientUserDetailsService implements UserDetailsService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Patient> optionalPatient = patientRepository.findByEmail(username);
        if(optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new User(patient.getEmail(),patient.getPassword(),authorities);
        }else{
            throw new BadCredentialsException("User Details not found with this username: "+username);
        }

    }
}
