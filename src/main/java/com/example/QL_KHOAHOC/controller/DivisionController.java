package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.ClassService;
import com.example.QL_KHOAHOC.Service.DivisionService;
import com.example.QL_KHOAHOC.entity.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/division")
class DivisionController {
 @Autowired
 DivisionService divisionService;
 @Autowired
 ClassService classService;
    @GetMapping("/getDivisions/{classId}")
    public List<Division> getDivisionsByClass(@PathVariable  int classId) {
        if(classId < 0)
            return null;
        var c = classService.getClassById(classId);
        if(c == null )
            return null;

        return divisionService.getAllDivisionsByClass(classId);
    }

    @PostMapping("/addOrUpdate")
    public String addOrupdateDivision(@RequestBody Division division) {
        if(division == null)
            return null;
        if(division.getId() == null)
            return null;
        Division dUpdate = divisionService.getDivisionById(division.getId());

        if(dUpdate == null)
            return null;
        if(division.getDivisionName() != "")
            dUpdate.setDivisionName(division.getDivisionName());
        if(division.getClassField().getId() != null)
            dUpdate.setClassField(division.getClassField());

        return  divisionService.addOrUpdateDivision(dUpdate);

    }
}
