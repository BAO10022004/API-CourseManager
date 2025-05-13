package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.entity.SubLessonLink;
import com.example.QL_KHOAHOC.responsitory.SubLessonLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubLessonLinkService {
    @Autowired
    private SubLessonLinkRepository repo;

    // Get all SubLessonLinks
    public List<SubLessonLink> getAllSubLessonLinks() {
        return repo.findAll();
    }

    // Get SubLessonLink by ID
    public SubLessonLink getSubLessonLinkById(int classlinkID) {
        Optional<SubLessonLink> result = repo.findById(classlinkID);
        return result.orElse(null);
    }

    // Get all SubLessonLinks by SubLesson ID
    public List<SubLessonLink> getSubLessonLinksBySubLessonId(int subLessonId) {
        return repo.findSubLessonLinksBySubLesson_Id(subLessonId);
    }

    // Get all SubLessonLinks by type
    public List<SubLessonLink> getSubLessonLinksByType(int typeId) {
        return repo.findSubLessonLinksByType_Id(typeId);
    }

    // Add a new SubLessonLink
    public boolean addSubLessonLink(SubLessonLink subLessonLink) {
        try {
            repo.save(subLessonLink);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing SubLessonLink
    public boolean updateSubLessonLink(SubLessonLink subLessonLink) {
        try {
            if (repo.existsById(subLessonLink.getId())) {
                repo.save(subLessonLink);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Add or update a SubLessonLink
    public boolean addOrUpdateSubLessonLink(SubLessonLink subLessonLink) {
        try {
            repo.save(subLessonLink);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a SubLessonLink by ID
    public boolean deleteSubLessonLinkById(int classlinkID) {
        try {
            if (repo.existsById(classlinkID)) {
                repo.deleteById(classlinkID);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete all SubLessonLinks for a specific SubLesson ID
    public boolean deleteSubLessonLinksBySubLessonId(int subLessonId) {
        try {
            List<SubLessonLink> links = repo.findSubLessonLinksById(subLessonId);
            repo.deleteAll(links);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}