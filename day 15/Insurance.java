package com.codinghusttle.real.hospitalManagemnet.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder

public class Insurance {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true , length = 30)
    private String PolicyNumber;

    @Column(nullable = false, length = 39 )
    private String provider ;

    @Column(nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    @Column (nullable = false, updatable = false)
    private LocalDateTime   createdAt;

    @OneToOne(mappedBy = "insurance")

    private Patient patient;

}
