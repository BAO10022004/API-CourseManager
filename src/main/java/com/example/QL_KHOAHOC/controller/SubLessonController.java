package com.example.QL_KHOAHOC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QL_KHOAHOC.Service.LessonService;
import com.example.QL_KHOAHOC.Service.SubLessonService;
import com.example.QL_KHOAHOC.entity.SubLesson;

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

    @PutMapping("/add")
    public String add(@RequestBody com.example.QL_KHOAHOC.dtoRequest.SubLesson subLesson) {
        SubLesson subLessonEntity = new SubLesson();
        subLessonEntity.setSubLessonName(subLesson.getSub());
        var lesson = lessonService.getLessonById(subLesson.getLessonId());
        if (lesson == null) {
            return "Lesson not found";
        }
        subLessonEntity.setLesson(lesson);
        var x = subLessonService.addOrUpdateSubLesson(subLessonEntity);
        if(x)
            return "OK";
        return "Failed";
    }
}