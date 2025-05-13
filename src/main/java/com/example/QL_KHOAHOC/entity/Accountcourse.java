package com.example.QL_KHOAHOC.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "accountcourse")
public class Accountcourse {
    @Id
    @ColumnDefault("0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_courseid", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Username", nullable = false)
    private Account username;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tearcher_course_id", nullable = false)
    private TeacherCourse tearcherCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    public TeacherCourse getTearcherCourse() {
        return tearcherCourse;
    }

    public void setTearcherCourse(TeacherCourse tearcherCourse) {
        this.tearcherCourse = tearcherCourse;
    }

}