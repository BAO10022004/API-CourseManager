package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.TeacherService;
import com.example.QL_KHOAHOC.dtoRespon.ResponsAllTeacher;
import com.example.QL_KHOAHOC.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/all")
    public  ResponseEntity<List<Teacher>>getAll() {
        var listTeacher = teacherService.getAllTeachers();
        if (listTeacher == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listTeacher);
    }


    @GetMapping("/getTeacherById/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(teacher);
    }
}
