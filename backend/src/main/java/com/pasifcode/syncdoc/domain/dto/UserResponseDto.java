package com.pasifcode.syncdoc.domain.dto;

import com.pasifcode.syncdoc.domain.enums.UserRoles;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String username;
    private String email;
    private UserRoles userRoles;
    private String profileImage;
    private String coverImage;
    private String userBio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
