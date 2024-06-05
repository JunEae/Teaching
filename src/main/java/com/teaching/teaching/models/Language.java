package com.teaching.teaching.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "language", schema = "public", catalog = "Teaching")
public class Language {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int languageId;
    @Column(name = "languageName")
    private String languageName;
}
