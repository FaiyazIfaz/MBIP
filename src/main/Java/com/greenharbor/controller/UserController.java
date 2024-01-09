package com.greenharbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.greenharbor.model.User;
import com.greenharbor.service.UserService;

@Controller
public class UserController {

 @Autowired
 private UserService userService;

 @GetMapping("/register")
 public String showRegistrationForm(Model model) {
     model.addAttribute("user", new User());
     return "registration";
 }

 @PostMapping("/register")
 public String processRegistration(@ModelAttribute("user") @Validated User user, BindingResult result) {
     if (result.hasErrors()) {
         return "registration";
     }
     
     user.setRole("USER"); // Set default role for simplicity
     userService.save(user);
     return "redirect:/login";
 }
}
