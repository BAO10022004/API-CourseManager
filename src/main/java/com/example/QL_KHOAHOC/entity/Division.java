package com.example.QL_KHOAHOC.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "division")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Division {
    @Id
    @Column(name = "division_id", nullable = false)
    private Integer id;

    @Column(name = "division_name", nullable = false, length = 50)
    private String divisionName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "class_id", nullable = false)
    private Class classField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Class getClassField() {
        return classField;
    }

    public void setClassField(Class classField) {
        this.classField = classField;
    }

}