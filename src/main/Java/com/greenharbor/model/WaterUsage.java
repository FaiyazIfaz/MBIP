package com.greenharbor.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//WaterUsage.java
@Entity
@Table(name = "water_usage")
public class WaterUsage {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "user_id", nullable = false)
 private User user;

 @Column(name = "usage_date", nullable = false)
 private LocalDate usageDate;

 @Column(name = "usage_amount", nullable = false)
 private double usageAmount;

 //Getters
 public Long getId() {
     return id;
 }

 public User getUser() {
     return user;
 }

 public LocalDate getUsageDate() {
     return usageDate;
 }

 public double getUsageAmount() {
     return usageAmount;
 }

 //Setters
 public void setId(Long id) {
     this.id = id;
 }

 public void setUser(User user) {
     this.user = user;
 }

 public void setUsageDate(LocalDate usageDate) {
     this.usageDate = usageDate;
 }

 public void setUsageAmount(double usageAmount) {
     this.usageAmount = usageAmount;
 }

}