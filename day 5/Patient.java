package com.codinghusttle.real.hospitalManagemnet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Timespan;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    private String name;


    private LocalDate birthdate;


    private String email;

    private String gender;


}
