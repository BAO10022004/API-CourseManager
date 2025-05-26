package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.ClassService;
import com.example.QL_KHOAHOC.Service.DivisionService;
import com.example.QL_KHOAHOC.dtoRequest.DivisionDTO;
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

    @PutMapping("/add")
    public String addOrupdateDivision(@RequestBody DivisionDTO division) {
        Division d = new Division();
        d.setDivisionName(division.divisionName);
        d.setClassField(classService.getClasses().stream().filter(x -> x.getId() == division.classID).findFirst().get());
        return  divisionService.addOrUpdateDivision(d);

    }
    @DeleteMapping("/{id}")
    public boolean deleteDivision(@PathVariable("id") int divisionID) {
        return divisionService.deleteDivision(divisionID);
    }
}
