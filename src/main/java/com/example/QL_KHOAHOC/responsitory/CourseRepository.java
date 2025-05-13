package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course getCoursesById(Integer id);
}