package com.abhideveloper.multipledbconnection.controller;

import com.abhideveloper.multipledbconnection.modal.SignUpModal;
import com.abhideveloper.multipledbconnection.service.SignUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/signup")
public class SignUpController {

    private final SignUpService signUpService;
    public SignUpController(SignUpService signUpService){
        this.signUpService=signUpService;
    }
    @PostMapping("SignUp")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpModal modal){
        signUpService.signUpUser(modal);
        return ResponseEntity.ok("User added successfully");
    }
}
