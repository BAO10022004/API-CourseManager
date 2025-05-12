package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.SubLesson;
import com.example.QL_KHOAHOC.responsitory.SubLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubLessonService {
    @Autowired
    private SubLessonRepository SubLessonRepository;

    public SubLesson getSubLessonById(int id) {
        return SubLessonRepository.findById(id).get();
    }
    public List<SubLesson> getAllSubLessonsByLessonId(int id) {
        return  SubLessonRepository.getSubLessonByLesson_Id(id);
    }
    public boolean deleteSubLessonById(int id) {
        try{
            SubLessonRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean addOrUpdateSubLesson(SubLesson s) {
        try{
            SubLessonRepository.saveAndFlush(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
