package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springrest.springrest.services.CourseService;

import java.util.List;

//@RestController using for generating  rest api and controller
//@Controller uses for normal application
@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/home")
    public String home() {

        return "Welcome to courses application";
    }


    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourse()
    {
        return this.courseService.getCourse();
    }

    //single courses get
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //course add
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }

    //update course using PUT request

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }
    //delete the course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
