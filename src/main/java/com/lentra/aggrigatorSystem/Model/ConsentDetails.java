package com.lentra.aggrigatorSystem.Model;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
public class ConsentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consentId;

    private int customerId;

    private String consentStatus;

    private int applicationId;

    private int lanNo;

    private int customerName;

    private String consentType;

    private LocalDate consentValidityTill;

    private LocalDate lastUpdatedDate;

    private int frequency;

    private int pullsRemaining;

    @ManyToOne
    @JoinColumn(name = "institude_id")
    private Institute consentInstitute;


    public ConsentDetails(int consentId , int customerId , String consentStatus , int applicationId , int lanNo , int customerName , String consentType , LocalDate consentValidityTill , LocalDate lastUpdatedDate , int frequency , int pullsRemaining , Institute consentInstitute) {
        this.consentId = consentId;
        this.customerId = customerId;
        this.consentStatus = consentStatus;
        this.applicationId = applicationId;
        this.lanNo = lanNo;
        this.customerName = customerName;
        this.consentType = consentType;
        this.consentValidityTill = consentValidityTill;
        this.lastUpdatedDate = lastUpdatedDate;
        this.frequency = frequency;
        this.pullsRemaining = pullsRemaining;
        this.consentInstitute = consentInstitute;
    }

    public ConsentDetails() {
    }

    public int getConsentId() {
        return consentId;
    }

    public void setConsentId(int consentId) {
        this.consentId = consentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(String consentStatus) {
        this.consentStatus = consentStatus;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getLanNo() {
        return lanNo;
    }

    public void setLanNo(int lanNo) {
        this.lanNo = lanNo;
    }

    public int getCustomerName() {
        return customerName;
    }

    public void setCustomerName(int customerName) {
        this.customerName = customerName;
    }

    public String getConsentType() {
        return consentType;
    }

    public void setConsentType(String consentType) {
        this.consentType = consentType;
    }

    public LocalDate getConsentValidityTill() {
        return consentValidityTill;
    }

    public void setConsentValidityTill(LocalDate consentValidityTill) {
        this.consentValidityTill = consentValidityTill;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getPullsRemaining() {
        return pullsRemaining;
    }

    public void setPullsRemaining(int pullsRemaining) {
        this.pullsRemaining = pullsRemaining;
    }

    public Institute getConsentInstitute() {
        return consentInstitute;
    }

    public void setConsentInstitute(Institute consentInstitute) {
        this.consentInstitute = consentInstitute;
    }
}
