package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    String getSubjectsById(int id);
}