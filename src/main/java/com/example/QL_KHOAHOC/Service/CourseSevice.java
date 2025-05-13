package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Course;
import com.example.QL_KHOAHOC.responsitory.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSevice {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(int id) {
        return courseRepository.getCoursesById(id);
    }
    public boolean addOrUpdateCourse(Course course) {
        try{
            courseRepository.save(course);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean deleteCourse(int id) {
        try{
            courseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
