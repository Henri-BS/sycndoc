package com.pasifcode.syncdoc.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CredentialsDto {
    private String email;
    private String password;
}
