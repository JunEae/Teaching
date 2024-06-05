package com.teaching.teaching.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bill", schema = "public", catalog = "Teaching")
public class Bill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int billId;
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "materialId", referencedColumnName = "materialId")
    private Material material;
}
