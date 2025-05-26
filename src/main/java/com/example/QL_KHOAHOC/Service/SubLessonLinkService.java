package com.example.QL_KHOAHOC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QL_KHOAHOC.entity.SubLessonLink;
import com.example.QL_KHOAHOC.responsitory.SubLessonLinkRepository;

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
                repo.saveAndFlush(subLessonLink); 
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addOrUpdateSubLessonLink(SubLessonLink subLessonLink) {
        try {
        var subLessonId = subLessonLink.getSubLesson().getId();
        var typeId = subLessonLink.getType().getId();
        
        // Đếm số record tồn tại trước khi xóa
        long countBefore = repo.count();
        System.out.println("Total records before: " + countBefore);
        
        // Tìm và xóa chính xác
        List<SubLessonLink> existingLinks = repo.findBySubLessonIdAndTypeId(subLessonId, typeId);
        System.out.println("Found " + existingLinks.size() + " links to delete");
        
        if (!existingLinks.isEmpty()) {
            // Xóa từng item thay vì deleteAll để an toàn hơn
            for (SubLessonLink link : existingLinks) {
                repo.delete(link);
                System.out.println("Deleted link ID: " + link.getId());
            }
        }
        
        // Save new
        repo.save(subLessonLink);
        
        long countAfter = repo.count();
        System.out.println("Total records after: " + countAfter);
        
        return true;
        
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }

// Phương thức hỗ trợ để cập nhật các field
private void updateFields(SubLessonLink existing, SubLessonLink newData) {
    if (newData.getLink() != null) {
        existing.setLink(newData.getLink());
    }
    if (newData.getSubLesson() != null) {
        existing.setSubLesson(newData.getSubLesson());
    }
    if (newData.getType() != null) {
        existing.setType(newData.getType());
    }
    // Thêm các field khác cần cập nhật...
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