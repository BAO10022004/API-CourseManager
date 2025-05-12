package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Subject;
import com.example.QL_KHOAHOC.responsitory.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<com.example.QL_KHOAHOC.entity.Subject> getSubjects() {
        return subjectRepository.findAll();
    }

}
