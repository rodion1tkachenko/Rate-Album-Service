package ru.o0000q.ratealbumservice.entity.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    ADMIN,USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
