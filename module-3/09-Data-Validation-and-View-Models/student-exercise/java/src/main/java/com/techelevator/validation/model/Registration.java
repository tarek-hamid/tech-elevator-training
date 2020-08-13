package com.techelevator.validation.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Registration {

    // Must Match Email
    // Must Match Password

    @Size(min = 1, max = 20, message = "First name must be 1 to 20 characters long.")
    private String firstName;

    @Size(min = 1, max = 20, message = "Last name must be 1 to 20 characters long.")
    private String lastName;

    @Email(message = "Please enter a valid email address.")
    @NotBlank(message = "Email is required")
    private String email;

    @Email(message = "Please enter a valid email address.")
    @NotBlank(message = "Please confirm your email")
    private String emailConfirm;

    private Boolean emailMatching;

    @Size(min=8, message = "Password must be minimum 8 characters")
    private String password;

    @NotBlank(message = "Please confirm your password")
    private String passwordConfirm;

    private Boolean passwordMatching;

    @Pattern(regexp = "^\\d{2}\\-\\d{2}-\\d{4}$", message = "Please enter the date in the following format MM-DD-YYYY.")
    private String birthdate;

    @Range(min = 1, max = 10, message = "Number of tickets must be between 1 and 10.")
    private String numberOfTickets;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(passwordConfirm);
        }
        return true;
    }

    @AssertTrue(message = "Emails must match")
    public boolean isEmailMatching() {
        if (email != null) {
            return email.equals(emailConfirm);
        }
        return true;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(String emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(String numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
