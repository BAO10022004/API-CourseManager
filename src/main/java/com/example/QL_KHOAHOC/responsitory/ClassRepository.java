package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Class;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Integer> {
  List<Class> getClassesByTeacherCourse(TeacherCourse teacherCourse);

  Class getClassesById(Integer id);
}