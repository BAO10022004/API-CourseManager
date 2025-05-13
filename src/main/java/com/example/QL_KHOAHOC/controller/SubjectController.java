package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.SubjectService;
import com.example.QL_KHOAHOC.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/all")
    ResponseEntity<List<Subject>> getAllSubjects() {
        var listSubject = subjectService.getSubjects();
        if(listSubject == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listSubject, HttpStatus.OK);
    }
    @PutMapping("/")
    ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        var res = subjectService.addSubject(subject);
        if(res == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteSubject(@PathVariable int id) {
        var res = subjectService.deleteSubject(id);
        if(!res)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }
}
