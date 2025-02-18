package com.BedanaYuksalish.BedanaYemlari.Service;

import com.BedanaYuksalish.BedanaYemlari.Entity.ProfileEntity;
import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileRole;
import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileStatus;
import com.BedanaYuksalish.BedanaYemlari.Repository.ProfileRepository;
import com.BedanaYuksalish.BedanaYemlari.Util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    protected ProfileRepository profileRepository;

    public void initProfile() {
        String email = "adminjon@gmail.com";
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndVisibleTrue(email);
        if (optional.isPresent()) {
            return;
        }
        ProfileEntity entity = new ProfileEntity();
        entity.setName("Admin");
        entity.setSurname("Admin");
        entity.setEmail(email);
        entity.setPassword(MD5Util.md5("12345"));
        entity.setRole(ProfileRole.ROLE_ADMIN);
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(Boolean.TRUE);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity); // saving into database
    }
}