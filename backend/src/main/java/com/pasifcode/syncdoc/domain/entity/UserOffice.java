package com.pasifcode.syncdoc.domain.entity;


import com.pasifcode.syncdoc.domain.enums.UserRoles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_user_office")
public class UserOffice extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    private LocalDateTime joinedAt;

    @Column(nullable = false)
    private Boolean active;
}
