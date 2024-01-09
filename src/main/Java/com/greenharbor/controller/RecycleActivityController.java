package com.greenharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.greenharbor.model.RecycleActivity;
import com.greenharbor.model.User;
import com.greenharbor.service.RecycleActivityService;

//RecycleActivityController.java
@Controller
public class RecycleActivityController {

 @Autowired
 private RecycleActivityService recycleActivityService;

 @GetMapping("/recycle-activity")
 public String showRecycleActivityForm(Model model) {
     model.addAttribute("recycleActivity", new RecycleActivity());
     return "recycle-activity";
 }

 @PostMapping("/recycle-activity")
 public String processRecycleActivity(@ModelAttribute("recycleActivity") @Validated RecycleActivity recycleActivity, BindingResult result) {
     if (result.hasErrors()) {
         return "recycle-activity";
     }

     // Set user based on authentication or session
     String username = "loggedInUsername"; // Replace with actual authentication logic
     User user = new User();
     user.setUsername(username);
     recycleActivity.setUser(user);

     recycleActivityService.save(recycleActivity);
     return "redirect:/dashboard";
 }

 @GetMapping("/dashboard")
 public String showDashboard(Model model) {
     // Retrieve and display recycle activity data on the dashboard
     String username = "loggedInUsername"; // Replace with actual authentication logic
     List<RecycleActivity> recycleActivityList = recycleActivityService.getAllRecycleActivityByUsername(username);
     model.addAttribute("recycleActivityList", recycleActivityList);
     return "dashboard";
 }
}
