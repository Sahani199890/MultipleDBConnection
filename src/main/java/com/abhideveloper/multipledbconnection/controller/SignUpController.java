package com.abhideveloper.multipledbconnection.controller;

import com.abhideveloper.multipledbconnection.entity.h2.SignUpEntity;
import com.abhideveloper.multipledbconnection.modal.SignUpModal;
import com.abhideveloper.multipledbconnection.service.SignUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class SignUpController {

    private final SignUpService signUpService;
    public SignUpController(SignUpService signUpService){
        this.signUpService=signUpService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpModal modal){
        return ResponseEntity.ok(signUpService.register(modal));
    }
    @PostMapping("/login")
    public ResponseEntity<?> signInUser(@RequestBody SignUpModal modal){
        return ResponseEntity.ok(signUpService.login(modal));
    }
}
