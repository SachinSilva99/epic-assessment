package com.sachin.assessmentspringboot.repo;

import com.sachin.assessmentspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

}
