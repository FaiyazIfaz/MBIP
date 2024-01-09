package com.greenharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenharbor.model.WaterUsage;

//WaterUsageRepository.java
public interface WaterUsageRepository extends JpaRepository<WaterUsage, Long> {

 List<WaterUsage> findByUser_Username(String username);

 // Additional query methods if needed
}
