package com.payMyBuddy.transfer.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UserRegistrationDto {


//    @NotNull
//    @NotEmpty(message="{registration.validation.email}")
//    @Email
    private String email;
//    @NotNull
//    @NotEmpty(message="{registration.validation.firstName}")
    private String firstName;
//    @NotNull
//    @NotEmpty(message="{registration.validation.lastName}")
    private String lastName;
//    @NotNull
//    @NotEmpty(message="{registration.validation.password}")
    private String password;
//    @NotNull
//    @NotEmpty(message="{registration.validation.phone}")
    private String phone;
////    @NotNull
////    @NotEmpty(message="{registration.validation.birthDate}")
//    private Date birthDate;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String email, String firstName, String lastName, String password, String phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //    public UserRegistrationDto(String email, String firstName, String lastName, String password, String phone, Date birthDate) {
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.phone = phone;
//        this.birthDate = birthDate;
//    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    @Override
//    public String toString() {
//        return "UserRegistrationDto{" +
//                "email='" + email + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", password='" + password + '\'' +
//                ", phone='" + phone + '\'' +
//                ", birthDate=" + birthDate +
//                '}';
//    }
}
