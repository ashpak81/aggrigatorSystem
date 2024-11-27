package com.lentra.aggrigatorSystem.Controller;

import com.lentra.aggrigatorSystem.Entity.ConsentDetails;
import com.lentra.aggrigatorSystem.Entity.Institute;
import com.lentra.aggrigatorSystem.Entity.Response;
import com.lentra.aggrigatorSystem.Entity.Users;
import com.lentra.aggrigatorSystem.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:4200" )
public class UsersController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }

    @PostMapping( "/login" )
    public ResponseEntity<?> login(@RequestBody Users user) {
        System.out.println(user);
        String token = service.verify(user);

        Response response = new Response(token, 200, true);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
