package com.BedanaYuksalish.BedanaYemlari.Controller;

import com.BedanaYuksalish.BedanaYemlari.DTO.AuthDTO;
import com.BedanaYuksalish.BedanaYemlari.DTO.ProfileDTO;
import com.BedanaYuksalish.BedanaYemlari.DTO.RegistrationDTO;
import com.BedanaYuksalish.BedanaYemlari.Service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth APIs")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/registration")
    @Operation(summary = "Registration", description = "This api used for registration new users")
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO dto) {
        return ResponseEntity.ok(authService.registration(dto));
    }

    @PostMapping("/login")
    @Operation(summary = "Authorization", description = "Api used for Authorization and Authentication")
    public ResponseEntity<ProfileDTO> login(@RequestBody @Valid AuthDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
