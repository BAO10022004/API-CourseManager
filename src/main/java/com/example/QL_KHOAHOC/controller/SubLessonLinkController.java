package com.example.QL_KHOAHOC.controller;

import com.example.QL_KHOAHOC.Service.SubLessonLinkService;
import com.example.QL_KHOAHOC.entity.SubLessonLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.QL_KHOAHOC.dtoRequest.SubLessonLinkDTO;

@RestController
@RequestMapping("/api/sublesson-links") // Prefix for all endpoints in this controller
public class SubLessonLinkController {
    @Autowired
    private SubLessonLinkService subLessonLinkService;
    @Autowired
    private com.example.QL_KHOAHOC.Service.SubLessonService subLessonService;
    @Autowired
    private com.example.QL_KHOAHOC.Service.TypeService typeService;
    // Get all SubLessonLinks
    @GetMapping("/all")
    public ResponseEntity<List<SubLessonLink>> getAllSubLessonLinks() {
        List<SubLessonLink> links = subLessonLinkService.getAllSubLessonLinks();
        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    // Get SubLessonLink by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubLessonLink> getSubLessonLinkById(@PathVariable int id) {
        SubLessonLink link = subLessonLinkService.getSubLessonLinkById(id);
        if (link != null) {
            return new ResponseEntity<>(link, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get SubLessonLinks by SubLesson ID
    @GetMapping("/by-sublesson/{subLessonId}")
    public ResponseEntity<List<SubLessonLink>> getSubLessonLinksBySubLessonId(@PathVariable int subLessonId) {
        List<SubLessonLink> links = subLessonLinkService.getSubLessonLinksBySubLessonId(subLessonId);
        if (links != null && !links.isEmpty()) {
            return new ResponseEntity<>(links, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get SubLessonLinks by type
    @GetMapping("/by-type/{typeId}")
    public ResponseEntity<List<SubLessonLink>> getSubLessonLinksByType(@PathVariable int typeId) {
        List<SubLessonLink> links = subLessonLinkService.getSubLessonLinksByType(typeId);
        if (links != null && !links.isEmpty()) {
            return new ResponseEntity<>(links, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new SubLessonLink
    @PostMapping("/create")
    public ResponseEntity<SubLessonLink> createSubLessonLink(@RequestBody SubLessonLinkDTO subLessonLink) {
        SubLessonLink subLessonLinkEntity = new SubLessonLink();
        subLessonLinkEntity.setSubLesson(subLessonService.getSubLessonById(subLessonLink.SublessonID));
        subLessonLinkEntity.setType(typeService.getTypeById(subLessonLink.type));
        subLessonLinkEntity.setLink(subLessonLink.link);

        boolean created = subLessonLinkService.addSubLessonLink(subLessonLinkEntity);
        if (created) {
            return new ResponseEntity<>(subLessonLinkEntity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Update an existing SubLessonLink
    @PutMapping("/update")
    public ResponseEntity<SubLessonLink> updateSubLessonLink(@RequestBody SubLessonLink subLessonLink) {
        boolean updated = subLessonLinkService.updateSubLessonLink(subLessonLink);
        if (updated) {
            return new ResponseEntity<>(subLessonLink, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add or update a SubLessonLink
    @PutMapping("/add-or-update")
    public ResponseEntity<SubLessonLink> addOrUpdateSubLessonLink(@RequestBody  SubLessonLinkDTO subLessonLink) {
        SubLessonLink subLessonLinkEntity = new SubLessonLink();
        subLessonLinkEntity.setSubLesson(subLessonService.getSubLessonById(subLessonLink.SublessonID));
        subLessonLinkEntity.setType(typeService.getTypeById(subLessonLink.type));
        subLessonLinkEntity.setLink(subLessonLink.link);
        boolean success = subLessonLinkService.addOrUpdateSubLessonLink(subLessonLinkEntity);
        if (success) {
            return new ResponseEntity<>(subLessonLinkEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Delete a SubLessonLink by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubLessonLinkById(@PathVariable int id) {
        SubLessonLink linkToDelete = subLessonLinkService.getSubLessonLinkById(id);
        if (linkToDelete != null) {
            boolean isDeleted = subLessonLinkService.deleteSubLessonLinkById(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete all SubLessonLinks for a specific SubLesson ID
    @DeleteMapping("/by-sublesson/{subLessonId}")
    public ResponseEntity<Void> deleteSubLessonLinksBySubLessonId(@PathVariable int subLessonId) {
        boolean isDeleted = subLessonLinkService.deleteSubLessonLinksBySubLessonId(subLessonId);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}