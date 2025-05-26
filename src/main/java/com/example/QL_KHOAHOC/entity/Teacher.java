package com.example.QL_KHOAHOC.entity;

import jakarta.persistence.*;

@Entity

@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacherID", nullable = false)
    private Integer id;

    @Column(name = "teacher_name", nullable = false, length = 50)
    private String teacherName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
     @PrePersist
    public void generateId() {
        if (this.id == null) {
            // Logic tạo ID tự động
            this.id = (int) System.currentTimeMillis(); 
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}