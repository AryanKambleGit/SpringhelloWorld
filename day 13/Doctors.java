package com.codinghusttle.real.hospitalManagemnet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


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

    @Column(nullable = false, length = 100 )
    private String specialization;

    @Column(nullable = false)
    private String email ;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();


}
