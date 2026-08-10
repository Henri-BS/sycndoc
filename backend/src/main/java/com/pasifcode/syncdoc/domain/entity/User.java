package com.pasifcode.syncdoc.domain.entity;

import com.pasifcode.syncdoc.domain.enums.UserRoles;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles userRoles;

    private String profileImage;

    private String coverImage;

    @Column(columnDefinition = "TEXT")
    private String userBio;

}