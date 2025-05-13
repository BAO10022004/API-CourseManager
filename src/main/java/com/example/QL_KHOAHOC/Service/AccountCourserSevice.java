package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Accountcourse;
import com.example.QL_KHOAHOC.responsitory.AccountcourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.util.List;

@Service
public class AccountCourserSevice {
    @Autowired
    AccountcourseRepository accountcourseRepository;

    public List<Accountcourse> getAccountcoursesByAccountId(String username) {
        return accountcourseRepository.getAccountcoursesByUsername_Username(username);
    }

    public Accountcourse getAccountcourse(long accountCourseID) {
        return  accountcourseRepository.getAccountcoursesById(accountCourseID);
    }

    public boolean addOrUpdateAccountcourse(Accountcourse accountcourse) {
        var list = accountcourseRepository.findAccountcourseByUsername(accountcourse.getUsername());
        var bool = list.stream().anyMatch(x ->x.getTearcherCourse().getId() == accountcourse.getTearcherCourse().getId());
        if(bool){
            return false;
        }
        try{
            accountcourseRepository.save(accountcourse);

            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Transactional
    public boolean deleteAccountcourse(int id) {
        try{
            accountcourseRepository.deleteAccountcoursesByTearcherCourse_Id(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Accountcourse> getAccountcourses() {
        return accountcourseRepository.findAll();
    }

}
