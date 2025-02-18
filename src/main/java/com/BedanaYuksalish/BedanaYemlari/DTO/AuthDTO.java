package com.BedanaYuksalish.BedanaYemlari.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}