package com.codinghusttle.real.hospitalManagemnet.entity;

import com.codinghusttle.real.hospitalManagemnet.type.BloodGroup;
import com.codinghusttle.real.hospitalManagemnet.type.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(

        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"})
        },
        indexes = {
                @Index(name = "idx_patient_birthdate", columnList = "birthDate")
        }
)
@Getter
@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //RELATIONSHIPS ARE STARTED FROM HERE

    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    @JoinColumn(name = "PatientInsuranceId" , nullable = true)  // Owning Side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient" , fetch = FetchType.EAGER)
    private List<Appointment> appointmentList = new ArrayList<>();


}