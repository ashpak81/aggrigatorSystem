package com.lentra.aggrigatorSystem.Controller;


import com.lentra.aggrigatorSystem.Model.Users;
import com.lentra.aggrigatorSystem.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping( "/a" )
    public String greet(HttpServletRequest request) {
        return "Welcome Ashpak " + request.getSession().getId();
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }

    @PostMapping( "/login" )
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }
}
