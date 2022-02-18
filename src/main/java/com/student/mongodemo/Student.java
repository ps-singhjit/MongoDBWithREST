package com.student.mongodemo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;

    public Student(String firstName, String lastName, String email, Gender gender,
            com.student.mongodemo.Address address, List<String> favouriteSubjects, BigDecimal totalSpentInBooks) {
        // LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", created=" + created + ", email=" + email + ", favouriteSubjects="
                + favouriteSubjects + ", firstName=" + firstName + ", gender=" + gender + ", id=" + id + ", lastName="
                + lastName + ", totalSpentInBooks=" + totalSpentInBooks + "]";
    }

}