package com.example.javamod6springweblab1.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateSignupDTO {
    @Min(value = 0)
    @Max(23)
    private Integer time;
    private Integer camper_id;
    private Integer activity_id;
}
