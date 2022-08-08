package com.example.javamod6springweblab1.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateCamperDTO {
    @NotBlank
    private String name;
    @Min(value = 8)
    @Max(18)
    private Integer age;
}
