package com.greenharbor.service;

import java.util.List;

import com.greenharbor.model.RecycleActivity;

//RecycleActivityService.java
public interface RecycleActivityService {
 void save(RecycleActivity recycleActivity);

 List<RecycleActivity> getAllRecycleActivityByUsername(String username);

 // Additional service methods if needed
}
