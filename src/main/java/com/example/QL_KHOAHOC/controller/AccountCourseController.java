package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.AccountCourserSevice;
import com.example.QL_KHOAHOC.Service.AccountService;
import com.example.QL_KHOAHOC.Service.TeacherCourseService;
import com.example.QL_KHOAHOC.dtoRequest.AccountcourseDTO;
import com.example.QL_KHOAHOC.entity.Account;
import com.example.QL_KHOAHOC.entity.Accountcourse;
import com.example.QL_KHOAHOC.entity.TeacherCourse;
import com.example.QL_KHOAHOC.responsitory.AccountResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acount-course")
class AccountCourseController {
@Autowired
    AccountCourserSevice accountcourseSevice;
@Autowired
AccountService accountService;
@Autowired
TeacherCourseService teacherCourseService;
    @GetMapping("/{username}")
    public List<Accountcourse> getAccountcourse(@PathVariable String username) {
        return accountcourseSevice.getAccountcoursesByAccountId(username);
    }
    @GetMapping("/id/{id}")
    public Accountcourse getAccountcourseById(@PathVariable long id) {
        return  accountcourseSevice.getAccountcourse(id);
    }
    @PutMapping("/add")
    public boolean addAccountcourse(@RequestBody AccountcourseDTO dto) {
        try {
            // Tìm đối tượng Account dựa trên username
            AccountResponsitory accountRepository;
            Account account = accountService.getAccountByUsername(dto.getUsername());
            if (account == null) {
                System.out.println("Không tìm thấy Account với username: " + dto.getUsername());
                return false;
            }

            // Tìm đối tượng TeacherCourse dựa trên ID
            TeacherCourse teacherCourse = teacherCourseService.getTeacherCourse(  dto.getteacherId(), dto.getCourseId());
            if (teacherCourse == null) {
                System.out.println("Không tìm thấy TeacherCourse với ID: " + dto.getteacherId() +""+ dto.getCourseId());
                return false;
            }

            Accountcourse accountcourse = new Accountcourse();
            accountcourse.setUsername(account);
            accountcourse.setTearcherCourse(teacherCourse);

            return accountcourseSevice.addOrUpdateAccountcourse(accountcourse);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @DeleteMapping("/{id}")
    public boolean deleteAccountcourse(@PathVariable int id) {
        return accountcourseSevice.deleteAccountcourse(id);
    }
    @GetMapping("/all")
    public List<Accountcourse> getAccountsCourse() {
        return accountcourseSevice.getAccountcourses();
    }
}
