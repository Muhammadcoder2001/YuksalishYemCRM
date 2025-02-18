package com.BedanaYuksalish.BedanaYemlari.DTO;

import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileRole;
import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ProfileStatus status;
    private ProfileRole role;
    private String photoId;
    private LocalDateTime createdDate;
    private String jwtToken;

}
