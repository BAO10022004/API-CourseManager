package com.example.QL_KHOAHOC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QL_KHOAHOC.entity.SubLesson;
import com.example.QL_KHOAHOC.responsitory.SubLessonRepository;

@Service
public class SubLessonService {
    @Autowired
    private SubLessonRepository subLessonRepository;
    public List<SubLesson> getAll() {
        return subLessonRepository.findAll();
    }
    public SubLesson getSubLessonById(int id) {
        return subLessonRepository.findById(id).get();
    }
    public List<SubLesson> getAllSubLessonsByLessonId(int id) {
        return  subLessonRepository.getSubLessonByLesson_Id(id);
    }
    public boolean deleteSubLessonById(int id) {
        try{
            subLessonRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean addOrUpdateSubLesson(SubLesson s) {
        try{
            subLessonRepository.save(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
