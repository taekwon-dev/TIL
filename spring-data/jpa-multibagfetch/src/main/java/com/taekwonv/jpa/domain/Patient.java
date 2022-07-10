package com.taekwonv.jpa.domain;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor leadingDoctor;

}