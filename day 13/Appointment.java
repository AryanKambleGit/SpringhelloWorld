package com.codinghusttle.real.hospitalManagemnet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(nullable = false, length = 500)
    private String reason ;

    @ManyToOne
    @JoinColumn(name= "patient_id", nullable = false) // P
    private Patient patient;


    //owner wuth doctor
    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctors doctors;

}
