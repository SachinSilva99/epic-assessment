package com.sachin.assessmentspringboot.service;

import com.sachin.assessmentspringboot.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    void createMovie(MovieDTO movieDTO);
    MovieDTO getMovie(String imdb);
    List<MovieDTO> getAllMovies();

    void updateMovie(MovieDTO movieDTO);
    void deleteMovie(String imdb);

}
