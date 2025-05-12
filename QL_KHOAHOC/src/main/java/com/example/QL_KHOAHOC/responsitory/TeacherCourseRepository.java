package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Course;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer> {
    Object getAllByCourse(Course course);

    List<TeacherCourse> getTeacherCourseByCourse(Course course);

    @Query("SELECT tc FROM TeacherCourse tc WHERE tc.teacher.id = :teacherId AND tc.course.id = :courseId")
    TeacherCourse findByTeacherIdAndCourseId(int teacherId, int courseId);
}