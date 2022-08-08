package com.example.javamod6springweblab1.controller;

import com.example.javamod6springweblab1.dto.CreateSignupDTO;
import com.example.javamod6springweblab1.dto.GetActivitiesDTO;
import com.example.javamod6springweblab1.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signups")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping
    public ResponseEntity<GetActivitiesDTO> createActivity(@Valid @RequestBody CreateSignupDTO createsignupDTO){
        GetActivitiesDTO activityDTO =  signupService.createSignup(createsignupDTO);
        return ResponseEntity.ok(activityDTO);
    }
}
