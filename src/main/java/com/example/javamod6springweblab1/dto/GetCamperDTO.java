package com.example.javamod6springweblab1.dto;

import com.example.javamod6springweblab1.model.Activity;
import com.example.javamod6springweblab1.model.Camper;
import com.example.javamod6springweblab1.model.Signup;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class GetCamperDTO {
    private int id;
    private String name;
    private Integer age;
    private List<GetActivitiesDTO> activities = new ArrayList<GetActivitiesDTO>();

    public void addActivityDTO(GetActivitiesDTO activityDTO){
        this.activities.add(activityDTO);
    }

}
