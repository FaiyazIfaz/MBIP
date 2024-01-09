package com.greenharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenharbor.model.ElectricityUsage;
//ElectricityUsageRepository.java
public interface ElectricityUsageRepository extends JpaRepository<ElectricityUsage, Long> {

 List<ElectricityUsage> findByUser_Username(String username);

 // Additional query methods if needed
}
