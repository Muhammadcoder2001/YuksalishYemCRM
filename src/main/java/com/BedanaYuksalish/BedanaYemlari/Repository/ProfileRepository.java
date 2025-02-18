package com.BedanaYuksalish.BedanaYemlari.Repository;

import com.BedanaYuksalish.BedanaYemlari.Entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {
    Optional<ProfileEntity> findByEmailAndVisibleTrue(String email);

}
