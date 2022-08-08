package com.example.javamod6springweblab1.controller;


import com.example.javamod6springweblab1.dto.CreateActivityDTO;
import com.example.javamod6springweblab1.dto.GetActivitiesDTO;
import com.example.javamod6springweblab1.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public GetActivitiesDTO createActivity( @RequestBody CreateActivityDTO createActivityDTO){
        return activityService.createActivity(createActivityDTO);
    }

    @GetMapping
    public List<GetActivitiesDTO> getActivities(){
        return activityService.getActivities();
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable(value = "id") Integer id){
        activityService.deleteActivity(id);
    }

}
