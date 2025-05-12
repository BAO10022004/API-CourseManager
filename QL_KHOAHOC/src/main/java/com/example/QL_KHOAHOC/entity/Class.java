package com.example.QL_KHOAHOC.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    private Integer id;

    @Column(name = "class_name", nullable = false, length = 100)
    private String className;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_course_id", nullable = false)
    private TeacherCourse teacherCourse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public TeacherCourse getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(TeacherCourse teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

}