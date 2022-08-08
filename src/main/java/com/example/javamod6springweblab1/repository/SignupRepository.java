package com.example.javamod6springweblab1.repository;

import com.example.javamod6springweblab1.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<Signup, Integer> {
}
