package com.sachin.assessmentspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Movie implements SuperEntity{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String imdb;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private String category;


    @Column(nullable = false)
    private Date year;

    @Column(nullable = false, columnDefinition = "LongText")
    @Lob
    private String imageUrl;
}
