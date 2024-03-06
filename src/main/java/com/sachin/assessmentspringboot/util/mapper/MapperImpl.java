package com.sachin.assessmentspringboot.util.mapper;

import com.sachin.assessmentspringboot.dto.MovieDTO;
import com.sachin.assessmentspringboot.dto.UserDTO;
import com.sachin.assessmentspringboot.entity.Movie;
import com.sachin.assessmentspringboot.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MapperImpl implements Mapper{
    private final ModelMapper mapper;
    @Override
    public User toUser(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    @Override
    public UserDTO toUserDto(User user) {
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public Movie toMovie(MovieDTO movieDTO) {
        return mapper.map(movieDTO, Movie.class);
    }

    @Override
    public MovieDTO toMovieDto(Movie movie) {
        return mapper.map(movie, MovieDTO.class);
    }
}
