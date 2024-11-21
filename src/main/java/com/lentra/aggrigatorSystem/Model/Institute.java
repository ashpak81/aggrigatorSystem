package com.lentra.aggrigatorSystem.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instituteId;

    private String instituteName;

    @OneToMany(mappedBy = "userInstitute" , cascade = CascadeType.ALL)
    private List<Users> usersList = new ArrayList<>();

    @OneToMany(mappedBy = "consentInstitute" ,cascade = CascadeType.ALL)
    private List<ConsentDetails> consentDetailsList = new ArrayList<>();

    public Institute(int instituteId , String instituteName , List<Users> usersList , List<ConsentDetails> consentDetailsList) {
        this.instituteId = instituteId;
        this.instituteName = instituteName;
        this.usersList = usersList;
        this.consentDetailsList = consentDetailsList;
    }

    public Institute() {
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public List<ConsentDetails> getConsentDetailsList() {
        return consentDetailsList;
    }

    public void setConsentDetailsList(List<ConsentDetails> consentDetailsList) {
        this.consentDetailsList = consentDetailsList;
    }
}
