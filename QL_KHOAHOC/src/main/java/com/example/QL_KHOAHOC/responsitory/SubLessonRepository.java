package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.SubLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubLessonRepository extends JpaRepository<SubLesson, Integer> {
    List<SubLesson> getSubLessonByLesson_Id(Integer lessonId);
}