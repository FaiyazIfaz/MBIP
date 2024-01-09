package com.greenharbor.service;

import java.util.List;

import com.greenharbor.model.WaterUsage;

//WaterUsageService.java
public interface WaterUsageService {
 void save(WaterUsage waterUsage);

 List<WaterUsage> getAllWaterUsageByUsername(String username);

 // Additional service methods if needed
}
