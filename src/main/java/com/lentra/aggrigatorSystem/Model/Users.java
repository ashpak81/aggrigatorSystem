package com.lentra.aggrigatorSystem.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    private String userId;

    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "Institude_id")
    private Institute userInstitute;

    public Users(String userId , String userPassword , Institute userInstitute) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userInstitute = userInstitute;
    }

    public Users() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Institute getUserInstitute() {
        return userInstitute;
    }

    public void setUserInstitute(Institute userInstitute) {
        this.userInstitute = userInstitute;
    }
}
