package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.dtoRespon.ResponsAllTeacher;
import com.example.QL_KHOAHOC.entity.Teacher;
import com.example.QL_KHOAHOC.responsitory.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        var list = teacherRepository.findAll();

        return list;
    }
    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).get();
    }
}
