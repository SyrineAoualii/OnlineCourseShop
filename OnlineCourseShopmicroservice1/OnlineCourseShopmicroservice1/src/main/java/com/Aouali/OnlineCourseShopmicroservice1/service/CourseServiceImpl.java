package com.Aouali.OnlineCourseShopmicroservice1.service;

import com.Aouali.OnlineCourseShopmicroservice1.model.Course;
import com.Aouali.OnlineCourseShopmicroservice1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course)
    {
        course.setCreateTime(LocalDateTime.now());

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId)
    {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> findAllCourses()
    {
        return courseRepository.findAll();
    }
}
