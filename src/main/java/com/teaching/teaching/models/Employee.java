package com.teaching.teaching.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee", schema = "public", catalog = "Teaching")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int employeeId;
    @Column(name = "fullName")
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "employeeCategoryId", referencedColumnName = "employeeCategoryId")
    private EmployeeCategory employeeCategory;
}
