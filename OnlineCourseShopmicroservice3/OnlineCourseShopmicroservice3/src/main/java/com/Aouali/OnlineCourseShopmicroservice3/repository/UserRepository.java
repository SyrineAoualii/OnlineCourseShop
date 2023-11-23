package com.Aouali.OnlineCourseShopmicroservice3.repository;

import com.Aouali.OnlineCourseShopmicroservice3.model.ERole;
import com.Aouali.OnlineCourseShopmicroservice3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
  /*  @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") ERole role);*/
}
