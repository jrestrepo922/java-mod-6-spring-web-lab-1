package com.example.javamod6springweblab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAMPERS")
@Getter
@Setter
public class Camper {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;

    @Min(value = 8)
    @Max(18)
    private Integer age;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "camper")
    private List<Signup> signups = new ArrayList<Signup>();

}
