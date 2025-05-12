package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

    List<Division> getAllByClassField_Id(Integer classFieldId);
}