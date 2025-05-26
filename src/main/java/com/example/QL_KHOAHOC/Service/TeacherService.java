package com.example.QL_KHOAHOC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QL_KHOAHOC.entity.Teacher;
import com.example.QL_KHOAHOC.responsitory.TeacherRepository;

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
 
    public Teacher addTeacher(Teacher teacher) {
        if (teacher.getTeacherName() == null || teacher.getTeacherName().isEmpty()) {
            return null; // Trả về null nếu tên giáo viên không hợp lệ
        }
        try{

            return teacherRepository.save(teacher);
        }catch (Exception e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi xảy ra trong quá trình lưu
        }
    }

    public boolean  delete(int  id) {
        try {
            teacherRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Trả về false nếu có lỗi xảy ra trong quá trình xóa
        }
    }
}
