package com.zessh.jumbo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakUserDTO {
    private String id;
    private String createdTimestamp;
    private String username;
    private boolean enabled;
    private boolean totp;
    private boolean emailVerified;
    private String firstName;
    private String lastName;
    private String email;
    private List<?> disableableCredentialTypes;
    private List<?> requiredActions;
    private int notBefore;
    private Map<String, Boolean> access;
}
