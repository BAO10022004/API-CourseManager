package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.SubLessonLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubLessonLinkRepository extends JpaRepository<SubLessonLink, Integer> {
    List<SubLessonLink> findSubLessonLinksById(Integer id);

    List<SubLessonLink> findSubLessonLinksByType_Id(Integer typeId);

    List<SubLessonLink> findSubLessonLinksBySubLesson_Id(Integer subLessonId);
}