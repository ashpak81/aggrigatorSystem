package com.lentra.aggrigatorSystem.Services;


import com.lentra.aggrigatorSystem.Model.Institute;
import com.lentra.aggrigatorSystem.Model.Users;
import com.lentra.aggrigatorSystem.Repository.InstituteRepository;
import com.lentra.aggrigatorSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UsersRepository repo;

    @Autowired
    private InstituteRepository inst;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

//    public Users register(Users user) {
//        user.setUserPassword(encoder.encode(user.getUserPassword()));
//        repo.save(user);
//        return user;
//    }

    public Users register(Users user) {
        // Check if the Institute is null or if the name is provided
        Institute institute = user.getUserInstitute();

        if (institute != null && institute.getInstituteName() != null) {
            // Try to find the institute in the database by name
            institute = inst.findByInstituteName(institute.getInstituteName());

            // If the institute does not exist, create a new one
            if (institute == null) {
                institute = new Institute();
                institute.setInstituteName(user.getUserInstitute().getInstituteName());
                // Save the institute to the database if needed
                inst.save(institute);
            }
        }

        // If the Institute is still null after the checks, throw an error
        if (institute == null) {
            throw new IllegalArgumentException("Institute is required.");
        }

        // Set the found or newly created institute to the user
        user.setUserInstitute(institute);

        // Encrypt the user's password
        user.setUserPassword(encoder.encode(user.getUserPassword()));

        // Save the user to the database
        repo.save(user);

        return user;
    }



//    public Users register(Users user) {
//        user.setUserPassword(encoder.encode(user.getUserPassword()));
//        repo.save(user);
//        return user;
//    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(), user.getUserPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserId());
        } else {
            return "fail";
        }
    }
}
