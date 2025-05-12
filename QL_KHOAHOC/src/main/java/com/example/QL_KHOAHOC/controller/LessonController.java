package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.DivisionService;
import com.example.QL_KHOAHOC.Service.LessonService;
import com.example.QL_KHOAHOC.entity.Division;
import com.example.QL_KHOAHOC.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
