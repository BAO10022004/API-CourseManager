package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.CourseSevice;
import com.example.QL_KHOAHOC.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course")
class CourseController {
    @Autowired
    CourseSevice courseSevice;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        var list = courseSevice.getAllCourses();
        if(list.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getById")
    public ResponseEntity<Course> getCourseById(int id) {
        var course = courseSevice.getCourseById(id);
        if(course==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/add/{name}")
    public ResponseEntity<Course> addOrUpdateCourse(@PathVariable String name) {
        Course course = new Course();
        course.setCourseName(name);
       if( courseSevice.addOrUpdateCourse(course))
        return new ResponseEntity<>(course, HttpStatus.OK);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable int id) {
        if(  courseSevice.deleteCourse(id))
            return ResponseEntity.ok(true);

        return ResponseEntity.badRequest().build();
    }
}
