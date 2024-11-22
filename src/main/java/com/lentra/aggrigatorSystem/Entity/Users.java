package com.lentra.aggrigatorSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    private String userId;

    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "Institude_id")
    private Institute userInstitute;


}