package com.lentra.aggrigatorSystem.Services;


import com.lentra.aggrigatorSystem.Entity.ConsentDetails;
import com.lentra.aggrigatorSystem.Entity.Institute;
import com.lentra.aggrigatorSystem.Entity.Users;
import com.lentra.aggrigatorSystem.Repository.ConsentDetailsRepository;
import com.lentra.aggrigatorSystem.Repository.InstituteRepository;
import com.lentra.aggrigatorSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;


    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UsersRepository userRepo;

    @Autowired
    private InstituteRepository instiRepo;

    @Autowired
    private ConsentDetailsRepository consRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {

        Institute institute = user.getUserInstitute();

        if (institute != null && institute.getInstituteName() != null) {
            institute = instiRepo.findByInstituteName(institute.getInstituteName());

            if (institute == null) {
                institute = new Institute();
                institute.setInstituteName(user.getUserInstitute().getInstituteName());
                instiRepo.save(institute);
            }
        }

        if (institute == null) {
            throw new IllegalArgumentException("Institute is required.");
        }

        user.setUserInstitute(institute);

        user.setUserPassword(encoder.encode(user.getUserPassword()));

        userRepo.save(user);

        return user;
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId() , user.getUserPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserId());
        } else {
            return "fail";
        }
    }


    public List<ConsentDetails> consentDetails(Users users) {


        try {
            if (users == null) {
                throw new IllegalArgumentException("User object cannot be null");
            }

            if (users.getUserInstitute() == null || users.getUserInstitute().getInstituteName() == null) {
                throw new IllegalArgumentException("Institute name cannot be null");
            }

            String instituteName = users.getUserInstitute().getInstituteName();
            Institute institute = instiRepo.findByInstituteName(instituteName);
            if (institute == null) {
                    throw new IllegalArgumentException("No institute found with name: " + instituteName);
            }

            List<ConsentDetails> consentDetails = consRepo.findAllByInstituteId(institute.getInstituteId());
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

