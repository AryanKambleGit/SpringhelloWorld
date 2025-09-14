package com.codinghusttle.real.hospitalManagemnet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


//@Table(
//        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"})
//        }
//
//        )
@Entity
@Getter
@Setter
public class Doctors {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 40 )
    private String email;

    @Column(nullable = false)
    private String speciality ;



}
