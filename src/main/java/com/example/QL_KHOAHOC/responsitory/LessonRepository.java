package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> getAllByDivision_Id(Integer divisionId);
}