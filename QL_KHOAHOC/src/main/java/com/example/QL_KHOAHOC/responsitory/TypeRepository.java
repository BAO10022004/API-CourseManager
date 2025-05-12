package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    List findTypesById(Integer id);

    Type getTypesById(Integer id);
}