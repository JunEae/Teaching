package com.teaching.teaching.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "material", schema = "public", catalog = "Teaching")
public class Material {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int MaterialId;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "availability")
    private boolean availability;
    @ManyToOne
    @JoinColumn(name = "knowledgeLevelId", referencedColumnName = "knowledgeLevelId")
    private KnowledgeLevel knowledgeLevel;
    @ManyToOne
    @JoinColumn(name = "languageId", referencedColumnName = "languageId")
    private Language language;
}
