package com.Aouali.OnlineCourseShopmicroservice3.service;

import com.Aouali.OnlineCourseShopmicroservice3.model.ERole;
import com.Aouali.OnlineCourseShopmicroservice3.model.User;

import java.util.Optional;

public interface UserService
{
   // User saveUser(User user);

    Optional<User> findByUsername(String username);

  //  void changeRole(ERole newRole, String username);
}
