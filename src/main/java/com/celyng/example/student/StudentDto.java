package com.celyng.example.student;


import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "FirstName should not be empty")
        String firstName,
        @NotEmpty(message = "LastName should not be empty")
        String lastName,
        String email,
        Integer schoolId
) {
}
