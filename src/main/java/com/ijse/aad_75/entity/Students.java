package com.ijse.aad_75.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentContact;

    @ManyToOne    // nomal kiwwata one to menny kiyala inna class eka mkkd balala eke idan thama nika dnne dn school ekai sudent ekai gaththama one to menny ne e unata dn me class eka manny ne anna e nisa manny to one dnne
    private School school;
}
