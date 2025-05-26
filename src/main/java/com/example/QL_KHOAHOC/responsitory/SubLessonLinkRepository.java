package com.example.QL_KHOAHOC.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QL_KHOAHOC.entity.SubLessonLink;

public interface SubLessonLinkRepository extends JpaRepository<SubLessonLink, Integer> {
    List<SubLessonLink> findSubLessonLinksById(Integer id);

    List<SubLessonLink> findSubLessonLinksByType_Id(Integer typeId);

    List<SubLessonLink> findSubLessonLinksBySubLesson_Id(Integer subLessonId);


    public void deleteBySubLessonIdAndTypeId(Integer id, Integer id0);

    public List<SubLessonLink> findBySubLessonIdAndTypeId(Integer subLessonId, Integer typeId);

}