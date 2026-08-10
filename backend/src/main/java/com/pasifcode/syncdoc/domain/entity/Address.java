package com.pasifcode.syncdoc.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_address")
public class Address extends BaseEntity {

    @Column(nullable = false)
    private Long sequenceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locality_id")
    private Locality locality;

    private String number;

    private String complement;

    private Double latitude;

    private Double longitude;

    @Column (length = 1000)
    private String directLink;

    private Boolean active;
}