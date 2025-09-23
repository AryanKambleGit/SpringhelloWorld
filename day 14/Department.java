package com.codinghusttle.real.hospitalManagemnet.entity;

import com.sun.source.doctree.DocTree;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.DocAttribute;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter@Setter
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true, length = 50)
    private String name;


    @OneToOne
    @JoinColumn
    private Doctors headDoctor; // owner side

    // NEw Table will create because of ManyToMAny Relaionship


    @ManyToMany
    @JoinTable(
            name = "my_DEP_DOC",
            joinColumns = @JoinColumn(name = "dept_id"),
            inverseJoinColumns = @JoinColumn(name="doct_id")

    )
    private Set<Doctors> doctor = new HashSet<>();


}
