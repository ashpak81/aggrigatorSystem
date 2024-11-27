package com.lentra.aggrigatorSystem.Services;

import com.lentra.aggrigatorSystem.Entity.ConsentDetails;
import com.lentra.aggrigatorSystem.Entity.Institute;
import com.lentra.aggrigatorSystem.Repository.ConsentDetailsRepository;
import com.lentra.aggrigatorSystem.Repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DashboardService {

    @Autowired
    InstituteRepository instiRepo;

    @Autowired
    ConsentDetailsRepository consRepo;

    public List<ConsentDetails> consentDetails(Institute institute) {


        try {
            if (institute == null) {
                throw new IllegalArgumentException("User object cannot be null");
            }

            if (institute.getInstituteName() == null ) {
                throw new IllegalArgumentException("Institute name cannot be null");
            }

            String instituteName = institute.getInstituteName();

            Institute institudAllData = instiRepo.findByInstituteName(instituteName);
            if (institudAllData == null) {
                throw new IllegalArgumentException("No institute found with name: " + instituteName);
            }

            List<ConsentDetails> consentDetails = consRepo.findAllByInstituteId(institudAllData.getInstituteId());
            if (consentDetails.isEmpty()) {
                throw new IllegalStateException("No consent details found for institute: " + instituteName);
            }

            return consentDetails;
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
            return Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
