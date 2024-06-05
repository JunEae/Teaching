package com.teaching.teaching.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "knowledgeLevel", schema = "public", catalog = "Teaching")
public class KnowledgeLevel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int knowledgeLevelId;
    @Column(name = "knowledgeLevelName")
    private String knowledgeLevelName;
}
