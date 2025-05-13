package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.Division;
import com.example.QL_KHOAHOC.responsitory.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    public List<Division> getAllDivisionsByClass(int classId) {
        return divisionRepository.getAllByClassField_Id(classId);
    }
    public  Division getDivisionById(int id) {
        return divisionRepository.getById(id);
    }
    public String addOrUpdateDivision(Division division) {
        try{
            divisionRepository.save(division);
            return "Division added successfully";
        }catch (Exception e){
            return e.getMessage().toString();
        }
    }
    public String deleteDivision(Division division) {
        try{
            divisionRepository.delete(division);
            return "Division deleted successfully";
        }
        catch (Exception e){
            return e.getMessage().toString();
        }
    }

}
