package com.sachin.assessmentspringboot.api;

import com.sachin.assessmentspringboot.auth.AuthService;
import com.sachin.assessmentspringboot.auth.AuthenticationRequest;
import com.sachin.assessmentspringboot.auth.AuthenticationResponse;
import com.sachin.assessmentspringboot.dto.UserDTO;
import com.sachin.assessmentspringboot.util.StandardResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserController {
    private final AuthService authService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardResponse<String>> signUp(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        authService.register(userDTO);
        StandardResponse<String> success =
                new StandardResponse<>("00", "Success", null);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardResponse<AuthenticationResponse>> login(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticate = authService.authenticate(authenticationRequest);
        StandardResponse<AuthenticationResponse> success =
                new StandardResponse<>("00", "Success", authenticate);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }


    @GetMapping("/test")
    public String get() {
        return "works";
    }
}
