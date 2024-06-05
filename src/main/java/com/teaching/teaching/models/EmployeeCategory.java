package com.teaching.teaching.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employeeCategory", schema = "public", catalog = "Teaching")
public class EmployeeCategory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int employeeCategoryId;
    @Column(name = "employeeCategoryName")
    private String employeeCategoryName;
}
