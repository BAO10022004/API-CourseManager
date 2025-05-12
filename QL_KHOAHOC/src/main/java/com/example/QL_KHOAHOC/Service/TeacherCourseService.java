package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Course;
import com.example.QL_KHOAHOC.entity.Teacher;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import com.example.QL_KHOAHOC.responsitory.TeacherCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherCourseService {
    @Autowired
    TeacherCourseRepository teacherCourseRepository;
    @Autowired
    CourseSevice courseSevice;
    @Autowired
    TeacherService teacherService;
    public List<Teacher> getTeacherByCourse(int course_id)
    {
        Course c = courseSevice.getCourseById(course_id);
        var list = teacherCourseRepository.getTeacherCourseByCourse(c);
        List<Teacher> teachers = new ArrayList<>();
        for (TeacherCourse t : list)
        {
            Teacher teacher = t.getTeacher();
            teachers.add(teacher);
        }
        return teachers;
    }

    public TeacherCourse getTeacherCourse(int teacherId, int courseId) {
        // Option 1: Direct query using repository (most efficient)
        return teacherCourseRepository.findByTeacherIdAndCourseId(teacherId, courseId);

        // Option 2: If you don't have a direct query method, but still more efficient than original
        // Course course = courseService.getCourseById(courseId);
        // Teacher teacher = teacherService.getTeacherById(teacherId);
        // return teacherCourseRepository.findByCourseAndTeacher(course, teacher);
    }
    public boolean addteacherCourse(TeacherCourse teacherCourse) {
        try{
            teacherCourseRepository.save(teacherCourse);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean delete(int  id) {
        try{
            teacherCourseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
