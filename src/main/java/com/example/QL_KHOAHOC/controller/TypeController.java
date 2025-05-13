package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.TypeService;
import com.example.QL_KHOAHOC.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types") // Prefix for all endpoints in this controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    // Get Type by ID
    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable int id) {
        Type type = typeService.getTypeById(id);
        if (type != null) {
            return new ResponseEntity<>(type, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all Types
    @GetMapping("/all")
    public ResponseEntity<List<Type>> getAllTypes() {
        List<Type> types = typeService.getTypes(0); // The parameter doesn't seem to be used in the service
        if (types != null && !types.isEmpty()) {
            return new ResponseEntity<>(types, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}