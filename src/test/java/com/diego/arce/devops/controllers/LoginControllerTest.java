package com.diego.arce.devops.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LoginControllerTest {


    @InjectMocks
    @Autowired
    private LoginController loginController;


    @BeforeEach
    void setUp() {

    }

    @Test
    void getToken() {
        String token = this.loginController.getToken();
        Assertions.assertNotNull(token);
    }
}