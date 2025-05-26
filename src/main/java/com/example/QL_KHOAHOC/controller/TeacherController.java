package com.example.QL_KHOAHOC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QL_KHOAHOC.Service.TeacherService;
import com.example.QL_KHOAHOC.dtoRequest.TeacherDTO;
import com.example.QL_KHOAHOC.entity.Teacher;
import com.example.QL_KHOAHOC.entity.Subject;
@RestController
@RequestMapping("/api/teacher")
@CrossOrigin(origins = "*")
class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    com.example.QL_KHOAHOC.Service.SubjectService subjectService;
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
    
    @PutMapping("/addTeacher")
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        try {
            // Validate input
            if (teacherDTO == null) {
                return ResponseEntity.badRequest().body("Teacher data is required");
            }
            
            if (teacherDTO.getName() == null || teacherDTO.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Teacher name is required");
            }
            
            // Debug log
            System.out.println("Received TeacherDTO: " + teacherDTO);
            
            // Find subject by ID
            Subject subject = subjectService.getSubjectById(teacherDTO.getSubject());
            if (subject == null) {
                return ResponseEntity.badRequest()
                    .body("Subject not found with ID: " + teacherDTO.getSubject());
            }
            
            // Convert DTO to Entity
            Teacher teacherEntity = new Teacher();
            teacherEntity.setTeacherName(teacherDTO.getName().trim());
            teacherEntity.setSubject(subject);
            
            // Save teacher
            Teacher addedTeacher = teacherService.addTeacher(teacherEntity);
            if (addedTeacher == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save teacher");
            }
            
            return ResponseEntity.status(HttpStatus.CREATED).body(addedTeacher);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error adding teacher: " + e.getMessage());
        }
    }
    //-------   Delete Teacher  -------//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }
        try{

            teacherService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build(); // Trả về lỗi server nếu có lỗi xảy ra
        }
    }
}
