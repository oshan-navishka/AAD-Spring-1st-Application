package com.ijse.aad_75.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long school_Id;
    private String school_Name;
    private String school_location;

    @OneToMany(mappedBy = "school",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Students> school;
}
