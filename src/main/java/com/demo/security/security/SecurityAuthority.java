package com.demo.security.security;

import org.springframework.security.core.GrantedAuthority;

import com.demo.security.entity.Rol;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Rol authority;

    @Override
    public String getAuthority() {
        return authority.getNombre().toString();
    }

}
