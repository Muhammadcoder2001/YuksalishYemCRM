package com.BedanaYuksalish.BedanaYemlari.Controller;

import com.BedanaYuksalish.BedanaYemlari.Service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/init")
@Tag(name = "Init Test Data APIs", description = "Test data APIs")
public class InitController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/test")
    @Operation(summary = "Init test user", description = "Creates a new user with login: adminjon@gmail.com , and password: 12345")
    public ResponseEntity<String> initUser() {
        profileService.initProfile();
        return ResponseEntity.ok("Done");
    }
}