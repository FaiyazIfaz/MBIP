package com.greenharbor.service;

import java.util.List;

import com.greenharbor.model.ElectricityUsage;

//ElectricityUsageService.java
public interface ElectricityUsageService {
 void save(ElectricityUsage electricityUsage);

 List<ElectricityUsage> getAllElectricityUsageByUsername(String username);

 // Additional service methods if needed
}
