package com.sachin.assessmentspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @Size(min = 3, max = 20)
    private String firstName;
    @Size(min = 3, max = 20)
    private String lastName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8, max = 100)
    private String password;
}
