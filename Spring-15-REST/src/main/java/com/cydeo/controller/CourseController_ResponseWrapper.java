package com.cydeo.controller;

import com.cydeo.entity.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper>getAllCourses(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Version" ,"Cydeo.v3")
                .body(new ResponseWrapper("successfully retrrived",courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper>getCourseById(@PathVariable("id") Long courseId){
        return ResponseEntity.ok(new ResponseWrapper("course : "+courseId + "Retried", courseService.getCourseById(courseId)));

    }

}
