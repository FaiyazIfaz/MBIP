package com.greenharbor.service;
import javax.security.auth.login.AccountNotFoundException;

import com.greenharbor.model.User;
//UserService.java
public interface UserService  {
 void save(User user);

User loadUserByUsername(String username) throws AccountNotFoundException;
}
