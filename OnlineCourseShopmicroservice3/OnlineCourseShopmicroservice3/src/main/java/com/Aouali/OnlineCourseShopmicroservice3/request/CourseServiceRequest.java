package com.Aouali.OnlineCourseShopmicroservice3.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sa
 * @date 10.10.2021
 * @time 13:14
 */
@FeignClient(value = "course-service"//Name of course-service application
        ,path = "/api/course"//Pre-path for course-service
       // ,url = "${course.service.url}"
        ,configuration = FeignConfiguration.class
)
public interface CourseServiceRequest
{
    @PostMapping("/save")///api/course
    Object saveCourse(@RequestBody Object requestBody);

    @DeleteMapping("delete/{courseId}")//api/course/{courseId}
    void deleteCourse(@PathVariable("courseId") Long courseId);

    @GetMapping("/getAll")//api/course
    List<Object> getAllCourses();
}
