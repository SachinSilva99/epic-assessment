package com.sachin.assessmentspringboot.repo;

import com.sachin.assessmentspringboot.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    Optional<Movie> findByImdb(String imdb);
}
