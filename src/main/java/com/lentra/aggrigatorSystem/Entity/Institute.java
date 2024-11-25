package com.lentra.aggrigatorSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instituteId;

    private String instituteName;

    @OneToMany(mappedBy = "userInstitute" , cascade = CascadeType.ALL)
    private Set<Users> usersList = new HashSet<>();

    @OneToMany(mappedBy = "consentInstitute" ,cascade = CascadeType.ALL)
    private Set<ConsentDetails> consentDetailsList = new HashSet<>();

}