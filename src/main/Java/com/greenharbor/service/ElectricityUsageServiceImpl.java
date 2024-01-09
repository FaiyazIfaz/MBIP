package com.greenharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenharbor.model.ElectricityUsage;
import com.greenharbor.repository.ElectricityUsageRepository;

//ElectricityUsageServiceImpl.java
@Service
public class ElectricityUsageServiceImpl implements ElectricityUsageService {

 @Autowired
 private ElectricityUsageRepository electricityUsageRepository;

 @Override
 public void save(ElectricityUsage electricityUsage) {
     electricityUsageRepository.save(electricityUsage);
 }

 @Override
 public List<ElectricityUsage> getAllElectricityUsageByUsername(String username) {
     return electricityUsageRepository.findByUser_Username(username);
 }
}
