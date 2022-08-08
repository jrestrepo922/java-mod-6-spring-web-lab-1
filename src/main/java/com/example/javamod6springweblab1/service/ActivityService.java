package com.example.javamod6springweblab1.service;

import com.example.javamod6springweblab1.dto.CreateActivityDTO;
import com.example.javamod6springweblab1.dto.GetActivitiesDTO;
import com.example.javamod6springweblab1.dto.GetCampersDTO;
import com.example.javamod6springweblab1.model.Activity;
import com.example.javamod6springweblab1.model.Camper;
import com.example.javamod6springweblab1.model.Signup;
import com.example.javamod6springweblab1.repository.ActivityRepository;
import com.example.javamod6springweblab1.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service // allows Spring to interact with my ActivityService class
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private ModelMapper mapper;



    public GetActivitiesDTO createActivity(CreateActivityDTO createActivityDTO){
        Activity activity = mapper.map(createActivityDTO, Activity.class);
        activity.setCreatedAt(LocalDate.now());
        activity = activityRepository.save(activity);
        return mapper.map(activity, GetActivitiesDTO.class);
    }

    public List<GetActivitiesDTO> getActivities(){
        return activityRepository.findAll().stream().map(activity -> mapper.map(activity, GetActivitiesDTO.class)).collect(Collectors.toList());
    }

    public void deleteActivity(Integer id){
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activity.getSignups().stream().forEach(signup -> signupRepository.delete(signup));
        activityRepository.deleteById(id);
    }
}
