package com.greenharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenharbor.model.WaterUsage;
import com.greenharbor.repository.WaterUsageRepository;

//WaterUsageServiceImpl.java
@Service
public class WaterUsageServiceImpl implements WaterUsageService {

 @Autowired
 private WaterUsageRepository waterUsageRepository;

 public void save1(WaterUsage waterUsage) {
     waterUsageRepository.save(waterUsage);
 }

 @Override
 public List<WaterUsage> getAllWaterUsageByUsername(String username) {
     return waterUsageRepository.findByUser_Username(username);
 }

@Override
public void save(WaterUsage waterUsage) {
	// TODO Auto-generated method stub
	
}

}
