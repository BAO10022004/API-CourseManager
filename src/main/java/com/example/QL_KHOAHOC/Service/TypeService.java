package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Type;
import com.example.QL_KHOAHOC.responsitory.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public Type getTypeById(int id) {
        return typeRepository.getTypesById(id);
    }
    public List<Type> getTypes(int id) {
        return typeRepository.findAll();
    }
    public Type createType(Type type) {
        if (type != null) {
            return typeRepository.save(type);
        } else {
            throw new IllegalArgumentException("Type cannot be null");
        }
    }
}
