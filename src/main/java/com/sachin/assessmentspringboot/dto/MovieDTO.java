package com.sachin.assessmentspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    private String imdb;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(1)
    private double rating;

    @NotBlank
    private String category;

    @NotNull
    private Date year;

    @NotBlank
    private String imageUrl;

}
