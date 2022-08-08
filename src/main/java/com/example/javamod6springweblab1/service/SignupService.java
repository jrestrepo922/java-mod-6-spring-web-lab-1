package com.example.javamod6springweblab1.service;

import com.example.javamod6springweblab1.dto.CreateActivityDTO;
import com.example.javamod6springweblab1.dto.CreateSignupDTO;
import com.example.javamod6springweblab1.dto.GetActivitiesDTO;
import com.example.javamod6springweblab1.model.Activity;
import com.example.javamod6springweblab1.model.Camper;
import com.example.javamod6springweblab1.model.Signup;
import com.example.javamod6springweblab1.repository.ActivityRepository;
import com.example.javamod6springweblab1.repository.CamperRepository;
import com.example.javamod6springweblab1.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CamperRepository camperRepository;
    @Autowired
    private ModelMapper mapper;

    public GetActivitiesDTO createSignup(CreateSignupDTO createSignupDTO){
        Camper camper = camperRepository.findById(createSignupDTO.getCamper_id()).get();
        Activity activity = activityRepository.findById(createSignupDTO.getActivity_id()).get();
        Signup signup = mapper.map(createSignupDTO, Signup.class);
        signup.setCreatedAt(LocalDate.now());
        signup.setActivity(activity);
        signup.setCamper(camper);
        signupRepository.save(signup);
        return mapper.map(activity, GetActivitiesDTO.class);
    }

}
