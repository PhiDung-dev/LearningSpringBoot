package com.example.LearningSpringBoot.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserUpdateRequest {

    @Size(min=8, message = "password must be at least 8 characters")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
