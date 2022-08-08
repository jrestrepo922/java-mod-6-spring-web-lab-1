package com.example.javamod6springweblab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name = "SIGNUPS")
@Getter
@Setter
public class Signup {

    @Id
    @GeneratedValue
    private int id;

    @Min(value = 0)
    @Max(23)
    private Integer time;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Camper camper;

}
