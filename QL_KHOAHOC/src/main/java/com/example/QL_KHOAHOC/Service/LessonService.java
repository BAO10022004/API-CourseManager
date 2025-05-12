package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Lesson;
import com.example.QL_KHOAHOC.responsitory.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    LessonRepository lessonRepository;

    public List<Lesson> getAllLessonsByDivision(int divisionId) {
        return lessonRepository.getAllByDivision_Id(divisionId);
    }
    public Lesson getLessonById(int lessonId) {
        return lessonRepository.findById(lessonId).get();
    }
}
