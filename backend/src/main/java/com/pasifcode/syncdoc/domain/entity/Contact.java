package com.pasifcode.syncdoc.domain.entity;

import com.pasifcode.syncdoc.domain.enums.ContactPlatform;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_contact")
public class Contact extends BaseEntity {

    @Column(nullable = false)
    private Long sequenceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContactPlatform platform;

    private String label;

    @Column(name = "contact_value", nullable = false)
    private String value;

    @Column(nullable = false)
    private Boolean primaryContact;

    @Column(nullable = false)
    private Boolean active;
}