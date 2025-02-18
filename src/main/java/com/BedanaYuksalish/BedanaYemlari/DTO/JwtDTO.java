package com.BedanaYuksalish.BedanaYemlari.DTO;

import lombok.AllArgsConstructor;

public class JwtDTO {

    public JwtDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }
    private String username;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
