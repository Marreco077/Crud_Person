package com.marreco.crud_person.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank String name,
        @NotBlank String lastName,
        @Email String email,
        @NotBlank String password
) { }
