package com.sachin.assessmentspringboot.util.mapper;

import com.sachin.assessmentspringboot.dto.UserDTO;
import com.sachin.assessmentspringboot.entity.User;

public interface Mapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDto(User user);
}
