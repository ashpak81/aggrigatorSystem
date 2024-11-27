package com.lentra.aggrigatorSystem.Controller;

import com.lentra.aggrigatorSystem.Entity.ConsentDetails;
import com.lentra.aggrigatorSystem.Entity.Institute;
import com.lentra.aggrigatorSystem.Services.DashboardService;
import com.lentra.aggrigatorSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:4200" )
public class DashboardController {


    @Autowired
    DashboardService service;

    @PostMapping("/dashboard")
    public List<ConsentDetails> consentDetailsByInstitudeId(@RequestBody Institute institute)
    {
        System.out.println(institute);
        return service.consentDetails(institute);
    }


}
