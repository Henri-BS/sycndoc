package com.pasifcode.syncdoc.domain.dto;

import com.pasifcode.syncdoc.domain.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String username;
    private String email;
    private String password;
    private UserRoles userRoles;
    private String profileImage;
    private String coverImage;
    private String userBio;
}
