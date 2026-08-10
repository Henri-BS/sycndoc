package com.pasifcode.syncdoc.domain.entity;

import com.pasifcode.syncdoc.domain.enums.ZoneType;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_locality")
public class Locality extends BaseEntity {

    @Column(nullable =false)
    private Long sequenceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(length = 100)
    private String region;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(length = 100)
    private String district;

    @Column(nullable = false, length = 150)
    private String name;

    @Enumerated(EnumType.STRING)
    private ZoneType zoneType;

    @Column(length = 1000)
    private String observations;

    private Boolean active;

}
