package com.Aouali.OnlineCourseShopmicroservice1.controller;

import com.Aouali.OnlineCourseShopmicroservice1.model.Course;
import com.Aouali.OnlineCourseShopmicroservice1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save") //api/course
    public ResponseEntity<?> saveCourse(@RequestBody Course course)
    {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{courseId}")//api/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId)
    {
        courseService.deleteCourse(courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll") //api/course
    public ResponseEntity<?> getAllCourses()
    {
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
