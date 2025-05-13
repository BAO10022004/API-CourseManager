package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.CourseSevice;
import com.example.QL_KHOAHOC.Service.TeacherCourseService;
import com.example.QL_KHOAHOC.Service.TeacherService;
import com.example.QL_KHOAHOC.dtoRequest.TeacherCourseDTO;
import com.example.QL_KHOAHOC.entity.Teacher;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher_course")
class TeacherCourseController {
    @Autowired
    private TeacherCourseService teacherCourseService;
    @Autowired
    private CourseSevice courseSevice;
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/get_teacher_course/{courseId}")
    public ResponseEntity<List<Teacher>> getTeacherCourseByCourseId(@PathVariable int courseId) {

        var teachers = teacherCourseService.getTeacherByCourse(courseId);
        if (teachers == null) {
            return  ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.ok(teachers);
    }
    @GetMapping("/all")
    public List<TeacherCourse> getAllTeacherCourse() {
        return teacherCourseService.getAll();
    }
    @GetMapping("/{teacherId}/{courseId}")
    public TeacherCourse getTeacherCourse(@PathVariable int teacherId, @PathVariable int courseId) {
        return teacherCourseService.getTeacherCourse(teacherId, courseId);
    }
    @PutMapping("/")
    public boolean addTeacherCourse(@RequestBody TeacherCourseDTO teacherCourse) {
        TeacherCourse teacherCourse1 = new TeacherCourse();
        teacherCourse1.setCourse(courseSevice.getCourseById(teacherCourse.courseId));
        teacherCourse1.setTeacher(teacherService.getTeacherById(teacherCourse.teacherId));
        return teacherCourseService.addteacherCourse(teacherCourse1);
    }
    @DeleteMapping("/{id}")
    public boolean deleteTeacherCourse(@PathVariable int id) {
        return teacherCourseService.delete(id);
    }
}
