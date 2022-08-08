package com.example.javamod6springweblab1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACTIVITIES")
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Integer difficulty;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "activity")
    private List<Signup> signups = new ArrayList<Signup>();
}
