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

@Entity
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"})
        },
        indexes = {
                @Index(name = "idx_patient_birthdate", columnList = "birthdate")
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
    private LocalDate birthdate;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    // ✅ enum stored as UPPERCASE (matches your enum constants)
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;

    // ✅ same for blood group
    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
