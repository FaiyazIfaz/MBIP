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

//RecycleActivity.java
@Entity
@Table(name = "recycle_activity")
public class RecycleActivity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "user_id", nullable = false)
 private User user;

 @Column(name = "activity_date", nullable = false)
 private LocalDate activityDate;

 @Column(name = "item_name", nullable = false)
 private String itemName;

 //Getters
 public Long getId() {
     return id;
 }

 public User getUser() {
     return user;
 }

 public LocalDate getActivityDate() {
     return activityDate;
 }

 public String getItemName() {
     return itemName;
 }

 //Setters
 public void setId(Long id) {
     this.id = id;
 }

 public void setUser(User user) {
     this.user = user;
 }

 public void setActivityDate(LocalDate activityDate) {
     this.activityDate = activityDate;
 }

 public void setItemName(String itemName) {
     this.itemName = itemName;
 }

}