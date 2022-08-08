package com.example.javamod6springweblab1.service;

import com.example.javamod6springweblab1.dto.CreateCamperDTO;
import com.example.javamod6springweblab1.dto.GetActivitiesDTO;
import com.example.javamod6springweblab1.dto.GetCamperDTO;
import com.example.javamod6springweblab1.dto.GetCampersDTO;
import com.example.javamod6springweblab1.model.Activity;
import com.example.javamod6springweblab1.model.Camper;
import com.example.javamod6springweblab1.model.Signup;
import com.example.javamod6springweblab1.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamperService {

    @Autowired
    private CamperRepository camperRepository;

    @Autowired
    private ModelMapper mapper ;

    public GetCampersDTO createCamper(CreateCamperDTO createCamperDTO){
        Camper camper = mapper.map(createCamperDTO, Camper.class);
        // The Mapper will create a camper with the fields of the DTO
        camper.setCreatedAt(LocalDate.now());
        camper = camperRepository.save(camper);
        // The mapper will take the fields from camper and make a DTO witch will
        // only show certain fields in JSON
        return mapper.map(camper, GetCampersDTO.class);
    }

    public List<GetCampersDTO> getCampers(){
        return camperRepository.findAll().stream().map(camper -> mapper.map(camper, GetCampersDTO.class)).collect(Collectors.toList());
    }

    public GetCamperDTO getCamper(Integer id){
        Camper camper = camperRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Camper not found"));
        GetCamperDTO dtoCamper = mapper.map(camper, GetCamperDTO.class);
        List<Signup> signups = camper.getSignups();
        List<Activity> activities = signups.stream().map(signup -> signup.getActivity()).toList();
        for(int i =0; i < activities.size(); i++){
            //need to map the activities to the correct format for the json response
            GetActivitiesDTO ActivityDTO = mapper.map(activities.get(i), GetActivitiesDTO.class);
            dtoCamper.addActivityDTO(ActivityDTO);
        }
        return dtoCamper;
    }

}
