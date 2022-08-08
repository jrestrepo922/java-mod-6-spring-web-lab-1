package com.example.javamod6springweblab1.controller;

import com.example.javamod6springweblab1.dto.CreateCamperDTO;
import com.example.javamod6springweblab1.dto.GetCamperDTO;
import com.example.javamod6springweblab1.dto.GetCampersDTO;
import com.example.javamod6springweblab1.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {

    @Autowired
    private CamperService camperService;

    @PostMapping
    public ResponseEntity<GetCampersDTO> createCamper(@Valid @RequestBody CreateCamperDTO createCamperDTO){
        GetCampersDTO camperDTO = camperService.createCamper(createCamperDTO);
        return ResponseEntity.ok(camperDTO);
    }

    @GetMapping
    public List<GetCampersDTO> getCampers(){
        return camperService.getCampers();
    }

    @GetMapping("/{id}")
    public GetCamperDTO getCamper(@PathVariable(value = "id") Integer id){
        GetCamperDTO camperDTO = camperService.getCamper(id);
        return camperDTO;
    }


}
