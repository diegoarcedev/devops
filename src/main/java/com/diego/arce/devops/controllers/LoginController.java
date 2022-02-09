package com.diego.arce.devops.controllers;

import com.diego.arce.devops.security.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping()
    public String getToken() {
        return jwtUtil.create("devops", "test devops");
    }

}
