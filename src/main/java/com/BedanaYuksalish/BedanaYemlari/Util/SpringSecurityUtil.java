package com.BedanaYuksalish.BedanaYemlari.Util;

import com.BedanaYuksalish.BedanaYemlari.Configuration.CustomUserDetails;
import com.BedanaYuksalish.BedanaYemlari.Enums.ProfileRole;
import com.BedanaYuksalish.BedanaYemlari.exps.AppForbiddenException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityUtil {

    public static void checkRoleExists(String profileRole, ProfileRole... requiredRoles) {
        for (ProfileRole requiredRole : requiredRoles) {
            if (requiredRole.name().equals(profileRole)) {
                return;
            }
        }
        throw new AppForbiddenException("Forbidden");
    }

    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user.getId();
    }

}
