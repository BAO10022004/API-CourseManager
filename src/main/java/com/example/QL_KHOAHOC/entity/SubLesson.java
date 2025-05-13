package com.example.QL_KHOAHOC.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_lesson")
public class SubLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_lesson_id", nullable = false)
    private Integer id;

    @Column(name = "sub_lesson_name", nullable = false, length = 100)
    private String subLessonName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubLessonName() {
        return subLessonName;
    }

    public void setSubLessonName(String subLessonName) {
        this.subLessonName = subLessonName;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}