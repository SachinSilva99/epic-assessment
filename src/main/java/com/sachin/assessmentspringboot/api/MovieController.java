package com.sachin.assessmentspringboot.api;

import com.sachin.assessmentspringboot.dto.MovieDTO;
import com.sachin.assessmentspringboot.service.MovieService;
import com.sachin.assessmentspringboot.util.StandardResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<StandardResponse<String>> createMovie(@Valid @RequestBody MovieDTO movieDTO) {
        movieService.createMovie(movieDTO);
        return new ResponseEntity<>(
                new StandardResponse<>("00", "Success", null), HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse<String>> updateMovie(@Valid @RequestBody MovieDTO movieDTO) {
        movieService.updateMovie(movieDTO);
        return new ResponseEntity<>(
                new StandardResponse<>("00", "Success", null), HttpStatus.OK
        );
    }

    @GetMapping(value = "/{imdb}")
    public ResponseEntity<StandardResponse<MovieDTO>> getMovie(@PathVariable String imdb) {
        MovieDTO movie = movieService.getMovie(imdb);
        return new ResponseEntity<>(
                new StandardResponse<>("00", "Success", movie), HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{imdb}")
    public ResponseEntity<StandardResponse<String>> deleteMovie(@PathVariable String imdb) {
        movieService.deleteMovie(imdb);
        return new ResponseEntity<>(
                new StandardResponse<>("00", "Success", null), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse<List<MovieDTO>>> getAllMovies() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(
                new StandardResponse<>("00", "Success", allMovies), HttpStatus.OK
        );
    }
}
