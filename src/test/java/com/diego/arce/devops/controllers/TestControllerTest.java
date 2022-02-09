package com.diego.arce.devops.controllers;

import com.diego.arce.devops.vo.RequestVO;
import com.diego.arce.devops.vo.ResponseVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TestControllerTest {

    @InjectMocks
    @Autowired
    private TestController testController;

    @InjectMocks
    @Autowired
    private LoginController loginController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void test1() {
        RequestVO requestVO = new RequestVO();
        requestVO.setMessage("");
        requestVO.setFrom("");
        requestVO.setTo("");
        requestVO.setTimeToLifeSec(5);
        String token = loginController.getToken();
        String expect = "Hello ".concat(requestVO.getTo()).concat(" your message will be send");
        ResponseEntity<ResponseVO> response = this.testController.test1(requestVO, token);
        Assertions.assertEquals(expect, response.getBody().getMessage());
    }

    @Test
    void test2() {
        String expect = "ERROR";
        String result = this.testController.test2();
        Assertions.assertEquals(expect, result);
    }
}