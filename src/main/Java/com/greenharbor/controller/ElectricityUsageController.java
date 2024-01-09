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

import com.greenharbor.model.ElectricityUsage;
import com.greenharbor.model.User;
import com.greenharbor.service.ElectricityUsageService;

//ElectricityUsageController.java
@Controller
public class ElectricityUsageController {

 @Autowired
 private ElectricityUsageService electricityUsageService;

 @GetMapping("/electricity-usage")
 public String showElectricityUsageForm(Model model) {
     model.addAttribute("electricityUsage", new ElectricityUsage());
     return "electricity-usage";
 }

 @PostMapping("/electricity-usage")
 public String processElectricityUsage(@ModelAttribute("electricityUsage") @Validated ElectricityUsage electricityUsage, BindingResult result) {
     if (result.hasErrors()) {
         return "electricity-usage";
     }

     // Set user based on authentication or session
     String username = "loggedInUsername"; // Replace with actual authentication logic
     User user = new User();
     user.setUsername(username);
     electricityUsage.setUser(user);

     electricityUsageService.save(electricityUsage);
     return "redirect:/dashboard";
 }

 @GetMapping("/dashboard")
 public String showDashboard(Model model) {
     // Retrieve and display electricity usage data on the dashboard
     String username = "loggedInUsername"; // Replace with actual authentication logic
     List<ElectricityUsage> electricityUsageList = electricityUsageService.getAllElectricityUsageByUsername(username);
     model.addAttribute("electricityUsageList", electricityUsageList);
     return "dashboard";
 }
}
