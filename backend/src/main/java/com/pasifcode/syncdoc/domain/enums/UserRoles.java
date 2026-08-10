package com.pasifcode.syncdoc.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRoles {
    ADMIN ("Admin"),
    USER ("Usuário");

    private final String description;

    UserRoles(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static UserRoles value(String description) {
        return switch (description) {
            case "Admin" -> ADMIN;
            case "Usuário" -> USER;
            default -> null;
        };
    }
}
