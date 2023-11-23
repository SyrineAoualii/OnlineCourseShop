package com.Aouali.OnlineCourseShopmicroservice1.repository;

import com.Aouali.OnlineCourseShopmicroservice1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long>
{

}
