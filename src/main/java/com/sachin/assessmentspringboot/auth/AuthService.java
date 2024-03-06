package com.sachin.assessmentspringboot.auth;

import com.sachin.assessmentspringboot.dto.UserDTO;
import com.sachin.assessmentspringboot.entity.User;
import com.sachin.assessmentspringboot.entity.enums.UserType;
import com.sachin.assessmentspringboot.exception.DuplicateException;
import com.sachin.assessmentspringboot.repo.UserRepo;
import com.sachin.assessmentspringboot.util.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final Mapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public void register(UserDTO userDTO) {
        System.out.println(userDTO);
        User user = mapper.toUser(userDTO);
        Optional<User> userByEmail = userRepo.findUserByEmail(userDTO.getEmail());
        if (userByEmail.isPresent()) {
            throw new DuplicateException("User Already Exists");
        }
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUserType(UserType.USER);
        userRepo.save(user);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userType", user.getUserType());
        var jwtToken = jwtService.generateToken(claims, user);
        AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepo.findUserByEmail(request.getEmail())
                .orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userType", user.getUserType());

        String jwtToken = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
