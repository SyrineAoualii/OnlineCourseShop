package com.Aouali.OnlineCourseShopmicroservice3.service;
import com.Aouali.OnlineCourseShopmicroservice3.model.ERole;
import com.Aouali.OnlineCourseShopmicroservice3.model.User;
import com.Aouali.OnlineCourseShopmicroservice3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;


    /*@Override
    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(ERole.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }*/

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

  /*  @Override
    @Transactional //Transactional is required when executing an update/delete query.
    public void changeRole(ERole newRole, String username)
    {
        userRepository.updateUserRole(username, newRole);
    }*/
}
