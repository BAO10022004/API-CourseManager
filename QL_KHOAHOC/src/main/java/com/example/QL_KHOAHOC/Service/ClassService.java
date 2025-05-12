package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Class;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import com.example.QL_KHOAHOC.responsitory.ClassRepository;
import com.example.QL_KHOAHOC.responsitory.TeacherCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
     @Autowired
     private ClassRepository classRepository;
    @Autowired
    private TeacherCourseService teacherCourseService;
     public List<Class> getClassByTeacherCourse(int teacher_id, int course_id) {
         TeacherCourse teacherCourse = teacherCourseService.getTeacherCourse(teacher_id, course_id);
            int i = teacherCourse.getId();
         return classRepository.getClassesByTeacherCourse(teacherCourse);
     }
     public Class getClassById(int id) {
         return classRepository.getClassesById(id);
     }
     public List<Class> getClasses( ) {
         return classRepository.findAll();
     }
}
