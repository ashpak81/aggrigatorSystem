package com.lentra.aggrigatorSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


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
    private List<Users> usersList = new ArrayList<>();

    @OneToMany(mappedBy = "consentInstitute" ,cascade = CascadeType.ALL)
    private List<ConsentDetails> consentDetailsList = new ArrayList<>();

}