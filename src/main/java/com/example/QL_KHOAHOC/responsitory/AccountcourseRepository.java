package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Account;
import com.example.QL_KHOAHOC.entity.Accountcourse;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountcourseRepository extends JpaRepository<Accountcourse, Long> {


    Accountcourse findAccountcourseById(Long id);

    List<Accountcourse> getAccountcoursesByUsername_Username(String usernameUsername);

    Accountcourse getAccountcoursesById(Long id);

    void deleteAccountcoursesById(Long id);

    List<Accountcourse> findAccountcourseByUsername(Account username);

    void deleteAccountcoursesByTearcherCourse(TeacherCourse tearcherCourse);

    void deleteAccountcoursesByTearcherCourse_Id(Integer tearcherCourseId);
}