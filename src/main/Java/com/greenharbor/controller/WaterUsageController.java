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

import com.greenharbor.model.User;
import com.greenharbor.model.WaterUsage;
import com.greenharbor.service.WaterUsageService;

//WaterUsageController.java
@Controller
public class WaterUsageController {

 @Autowired
 private WaterUsageService waterUsageService;

 @GetMapping("/water-usage")
 public String showWaterUsageForm(Model model) {
     model.addAttribute("waterUsage", new WaterUsage());
     return "water-usage";
 }

 @PostMapping("/water-usage")
 public String processWaterUsage(@ModelAttribute("waterUsage") @Validated WaterUsage waterUsage, BindingResult result) {
     if (result.hasErrors()) {
         return "water-usage";
     }

     // Set user based on authentication or session
     String username = "loggedInUsername"; // Replace with actual authentication logic
     User user = new User();
     user.setUsername(username);
     waterUsage.setUser(user);

     waterUsageService.save(waterUsage);
     return "redirect:/dashboard";
 }

 @GetMapping("/dashboard")
 public String showDashboard(Model model) {
     // Retrieve and display water usage data on the dashboard
     String username = "loggedInUsername"; // Replace with actual authentication logic
     List<WaterUsage> waterUsageList = waterUsageService.getAllWaterUsageByUsername(username);
     model.addAttribute("waterUsageList", waterUsageList);
     return "dashboard";
 }
}
