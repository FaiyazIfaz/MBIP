package com.greenharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenharbor.model.RecycleActivity;
import com.greenharbor.repository.RecycleActivityRepository;

//RecycleActivityServiceImpl.java
@Service
public class RecycleActivityServiceImpl implements RecycleActivityService {

 @Autowired
 private RecycleActivityRepository recycleActivityRepository;

 @Override
 public void save(RecycleActivity recycleActivity) {
     recycleActivityRepository.save(recycleActivity);
 }

 @Override
 public List<RecycleActivity> getAllRecycleActivityByUsername(String username) {
     return recycleActivityRepository.findByUser_Username(username);
 }
}
