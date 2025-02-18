package com.BedanaYuksalish.BedanaYemlari.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    @NotBlank
    private String name;
    private String surname;
    private String email;
    private String password;
}
