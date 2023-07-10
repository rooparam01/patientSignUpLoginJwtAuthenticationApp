package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The name field cannot be left empty. Please enter a valid name.")
    @NotBlank(message = "The name field cannot be spaces. Please enter a valid name.")
    private String name;


    @Email(message = "The email you entered is not valid. Please enter a valid email address.")
    @Column(unique = true)
    private String email;
    private String mobile;

    @NotNull(message = "The password field cannot be left empty. Please enter a valid password.")
    @NotBlank(message = "The password field cannot be spaces. Please enter a valid password.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String address;

    private String pincode;

    private String role;
}
