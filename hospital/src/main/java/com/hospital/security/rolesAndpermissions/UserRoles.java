package com.hospital.security.rolesAndpermissions;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.hospital.security.rolesAndpermissions.UserPermissions.*;

public enum UserRoles {

    ADMIN(Sets.newHashSet(PATIENT_WRITE)),
    RECIPTIONIST(Sets.newHashSet());
    private final Set<UserPermissions>permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

}
