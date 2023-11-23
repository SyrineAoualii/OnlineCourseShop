package com.Aouali.OnlineCourseShopmicroservice3.repository;

import com.Aouali.OnlineCourseShopmicroservice3.model.ERole;
import com.Aouali.OnlineCourseShopmicroservice3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
