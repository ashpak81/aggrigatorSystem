package com.lentra.aggrigatorSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consentId;

    private String customerId;

    private String consentStatus;

    private String applicationId;

    private int lanNo;

    private String customerName;

    private String consentType;

    private LocalDate consentValidityTill;

    private LocalDate lastUpdatedDate;

    private int frequency;

    private int pullsRemaining;

    private String FIType;

    @ManyToOne
    @JoinColumn(name = "institude_id")
    private Institute consentInstitute;



}