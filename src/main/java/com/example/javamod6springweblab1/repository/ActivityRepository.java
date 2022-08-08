package com.example.javamod6springweblab1.repository;

import com.example.javamod6springweblab1.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
