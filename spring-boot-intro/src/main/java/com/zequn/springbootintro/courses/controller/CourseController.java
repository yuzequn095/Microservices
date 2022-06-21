package com.zequn.springbootintro.courses.controller;

import com.zequn.springbootintro.courses.bean.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    /*
     * get the whole course list
     */
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return Arrays.asList(new Course(1, "CS 101", "Spring Boot"),
                             new Course(2, "CS 102", "Spring Cloud"));
    }

    /*
     * get a specific course, eg. 1
     */
    @GetMapping("/courses/1")
    public Course getSpecificCourses(){
        return new Course(1, "CS 101", "Spring Boot");
    }
}
