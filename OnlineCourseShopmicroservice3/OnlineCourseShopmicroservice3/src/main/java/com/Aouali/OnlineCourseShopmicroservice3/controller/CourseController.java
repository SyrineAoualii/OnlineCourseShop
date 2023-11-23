package com.Aouali.OnlineCourseShopmicroservice3.controller;

import com.Aouali.OnlineCourseShopmicroservice3.request.CourseServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author sa
 * @date 10.10.2021
 * @time 13:23
 */
@RestController
@RequestMapping("gateway/course")//pre-path
public class CourseController
{
    @Autowired
    private CourseServiceRequest courseServiceRequest;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save") //gateway/course
    public ResponseEntity<?> saveCourse(@RequestBody Object course)
    {
        return new ResponseEntity<>(courseServiceRequest.saveCourse(course), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{courseId}")//gateway/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId)
    {
        courseServiceRequest.deleteCourse(courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")//gateway/course
    public ResponseEntity<?> getAllCourses()
    {
        return ResponseEntity.ok(courseServiceRequest.getAllCourses());
    }
}
