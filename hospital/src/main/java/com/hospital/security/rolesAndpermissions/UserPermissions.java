package com.hospital.security.rolesAndpermissions;

public enum UserPermissions {

PATIENT_WRITE("patient_write"),
PATIENT_ٌُِREAD("patient_read"),


;
    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }
}
