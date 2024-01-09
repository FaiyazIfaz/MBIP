package com.greenharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenharbor.model.RecycleActivity;

//RecycleActivityRepository.java
public interface RecycleActivityRepository extends JpaRepository<RecycleActivity, Long> {

 List<RecycleActivity> findByUser_Username(String username);

 // Additional query methods if needed
}
