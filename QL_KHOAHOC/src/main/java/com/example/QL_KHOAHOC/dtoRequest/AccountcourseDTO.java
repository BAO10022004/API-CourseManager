package com.example.QL_KHOAHOC.dtoRequest;

public class AccountcourseDTO {
    private String username;
    private int teacherId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    private int courseId;
    // Getters và setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getteacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherCourseId) {
        this.teacherId = teacherCourseId;
    }
}