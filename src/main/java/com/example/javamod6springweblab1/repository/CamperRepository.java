package com.example.javamod6springweblab1.repository;

import com.example.javamod6springweblab1.model.Camper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamperRepository extends JpaRepository<Camper, Integer> {
}
