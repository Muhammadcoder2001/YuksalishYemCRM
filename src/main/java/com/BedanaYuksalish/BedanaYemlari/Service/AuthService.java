package com.BedanaYuksalish.BedanaYemlari.Service;

import com.BedanaYuksalish.BedanaYemlari.Configuration.JwtProvider;
import com.BedanaYuksalish.BedanaYemlari.DTO.AuthDTO;
import com.BedanaYuksalish.BedanaYemlari.DTO.ProfileDTO;
import com.BedanaYuksalish.BedanaYemlari.DTO.RegistrationDTO;
import com.BedanaYuksalish.BedanaYemlari.Entity.ProfileEntity;
import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileRole;
import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileStatus;
import com.BedanaYuksalish.BedanaYemlari.Repository.ProfileRepository;
import com.BedanaYuksalish.BedanaYemlari.Util.MD5Util;
import com.BedanaYuksalish.BedanaYemlari.exps.AppBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;

    public String registration(RegistrationDTO dto) {
        // check email exists
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndVisibleTrue(dto.getEmail());
        if (optional.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(MD5Util.md5(dto.getPassword()));
        entity.setSurname(dto.getSurname());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(Boolean.TRUE);
        entity.setRole(ProfileRole.ROLE_USER);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        return "Registration was successfully";
    }

    public ProfileDTO login(AuthDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndVisibleTrue(dto.getEmail());
        if (optional.isEmpty()) {
            throw new AppBadRequestException(" Email or Password wrong");
        }
        ProfileEntity entity = optional.get();
        if (!entity.getPassword().equals(MD5Util.md5(dto.getPassword()))) {
            throw new AppBadRequestException(" Email or Password wrong");
        }
        if (!entity.getStatus().equals(ProfileStatus.ACTIVE)) {
            throw new AppBadRequestException(" Email or Password wrong");
        }
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setName(entity.getName());
        profileDTO.setSurname(entity.getSurname());
        profileDTO.setEmail(entity.getEmail());
        profileDTO.setRole(entity.getRole());
        profileDTO.setJwtToken(JwtProvider.encode(entity.getEmail(), entity.getRole().toString()));
        return profileDTO;
    }
}
