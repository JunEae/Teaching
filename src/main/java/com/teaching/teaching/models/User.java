package com.teaching.teaching.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user", schema = "public", catalog = "Teaching")
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "userage")
    private int userAge;
    @Column(name = "role")
    private String role;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
