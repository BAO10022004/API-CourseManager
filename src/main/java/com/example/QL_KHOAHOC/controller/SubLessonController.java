package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.LessonService;
import com.example.QL_KHOAHOC.Service.SubLessonService;
import com.example.QL_KHOAHOC.entity.Lesson;
import com.example.QL_KHOAHOC.entity.SubLesson;
import com.example.QL_KHOAHOC.responsitory.LessonRepository;
import com.example.QL_KHOAHOC.responsitory.SubLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sublesson")
class SubLessonController {
    @Autowired
    private SubLessonService subLessonService;
    @Autowired
    private LessonService lessonService;

    @GetMapping("/getAllByLesson/{lesson_id}")
    public List<SubLesson> allByLesson(@PathVariable int lesson_id) {
        var lesson = lessonService.getLessonById(lesson_id);
        if (lesson == null) {
            return null;
        }
        return subLessonService.getAllSubLessonsByLessonId(lesson_id);
    }

    @GetMapping("/getById/{id}")
    public SubLesson getById(@PathVariable int id) {
        return subLessonService.getSubLessonById(id);
    }
    @GetMapping("/all")
    public List<SubLesson> getAll() {
        return subLessonService.getAll();
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        var x = subLessonService.deleteSubLessonById(id);
        if(x)
            return "OK";
        return "Failed";
    }

    @PutMapping("/addOrUpdate")
    public String addOrUpdate(@RequestBody SubLesson subLesson) {
        var x = subLessonService.addOrUpdateSubLesson(subLesson);
        if(x)
            return "OK";
        return "Failed";
    }
}