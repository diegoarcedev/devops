package com.diego.arce.devops.controllers;

import com.diego.arce.devops.security.jwt.JWTUtil;
import com.diego.arce.devops.vo.RequestVO;
import com.diego.arce.devops.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DevOps")
public class TestController {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping()
    public ResponseEntity<ResponseVO> test1(@RequestBody RequestVO requestVO, @RequestHeader(value = "X-JWT-KWY") String token) {

        if (jwtUtil.getKey(token) != null) {
            ResponseVO responseVO = new ResponseVO();
            responseVO.setMessage("Hello ".concat(requestVO.getTo()).concat(" your message will be send"));
            return new ResponseEntity<>(responseVO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
            RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.TRACE})
    public String test2() {
        return "ERROR";
    }


}
