package com.sachin.assessmentspringboot.service.impl;

import com.sachin.assessmentspringboot.dto.MovieDTO;
import com.sachin.assessmentspringboot.entity.Movie;
import com.sachin.assessmentspringboot.exception.NotFoundException;
import com.sachin.assessmentspringboot.repo.MovieRepo;
import com.sachin.assessmentspringboot.service.MovieService;
import com.sachin.assessmentspringboot.util.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepo movieRepo;
    private final Mapper mapper;

    @Override
    public void createMovie(MovieDTO movieDTO) {
        if (movieRepo.findByImdb(movieDTO.getImdb()).isPresent()) {
            throw new NotFoundException("Movie Already Exists");
        }
        Movie movie = mapper.toMovie(movieDTO);
        movieRepo.save(movie);
    }

    @Override
    public MovieDTO getMovie(String imdb) {
        Movie movie = movieRepo.findByImdb(imdb).orElseThrow(() -> new NotFoundException("No Such Movie Found"));
        return mapper.toMovieDto(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepo.findAll().stream().map(mapper::toMovieDto).toList();
    }

    @Override
    public void updateMovie(MovieDTO movieDTO) {
        Movie movie = movieRepo
                .findByImdb(movieDTO.getImdb())
                .orElseThrow(() -> new NotFoundException("No Such Movie Found"));

        movie.setImdb(movieDTO.getImdb());
        movie.setDescription(movieDTO.getDescription());
        movie.setYear(movieDTO.getYear());
        movie.setCategory(movieDTO.getCategory());
        movie.setTitle(movieDTO.getTitle());
        movie.setRating(movieDTO.getRating());
        movie.setImageUrl(movieDTO.getImageUrl());
        movieRepo.save(movie);

    }

    @Override
    public void deleteMovie(String imdb) {
        Movie movie = movieRepo
                .findByImdb(imdb)
                .orElseThrow(() -> new NotFoundException("No Such Movie Found"));
        movieRepo.deleteById(movie.getId());
    }
}
