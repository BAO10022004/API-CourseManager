package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.DivisionService;
import com.example.QL_KHOAHOC.Service.LessonService;
import com.example.QL_KHOAHOC.dtoRequest.LessonDTO;
import com.example.QL_KHOAHOC.entity.Division;
import com.example.QL_KHOAHOC.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private DivisionService divisionService;
    @GetMapping("/getAllByDivision/{division_id}")
    public List<Lesson> getAllByDivision(@PathVariable int division_id) {

        return lessonService.getAllLessonsByDivision(division_id);
    }
    @GetMapping("/getById")
    public Lesson getLessonById(int lesson_id) {
        return  lessonService.getLessonById(lesson_id);
    }
    @GetMapping("/all")
    public List<Lesson> getAll() {

        return lessonService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLesson(@PathVariable int id) {
        var res =  lessonService.deleteLesson(id);
        if(!res)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
    @PutMapping("/add")
    public ResponseEntity<Boolean> updateLesson(@RequestBody LessonDTO lesson) {
        Lesson l = new Lesson();
        l.setLessonName(lesson.getLessonName());
        l.setDivision(divisionService.getDivisionById(lesson.getDivisionID()));
        var res = lessonService.save(l);
        if(res == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
