package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.ClassService;
import com.example.QL_KHOAHOC.dtoRequest.ClassRequest;
import com.example.QL_KHOAHOC.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/get_class/{teacher_id}/{course_id}")
    public ResponseEntity<List<Class>> getClassByTeacherCourse(
            @PathVariable("teacher_id") int teacherId,
            @PathVariable("course_id") int courseId) {

        var res = classService.getClassByTeacherCourse(teacherId, courseId);
        if (res == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Class>> getAll() {
        return ResponseEntity.ok(classService.getClasses()) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Class> deleteClass(@PathVariable("id") int id) {
        var res = classService.deleteClass(id);
        if (res)
        {
            return  new ResponseEntity<>(null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/")
    public ResponseEntity<Class> add(@RequestBody Class classRequest) {
        var res = classService.addClass(classRequest);
        if(res)
        {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
