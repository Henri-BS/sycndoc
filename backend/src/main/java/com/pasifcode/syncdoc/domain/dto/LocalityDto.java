package com.pasifcode.syncdoc.domain.dto;

import com.pasifcode.syncdoc.domain.enums.ZoneType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalityDto implements Serializable {

    private UUID id;

    private Long sequenceNumber;

    private UUID officeId;

    private UUID routeId;

    private String country;

    private String region;

    private String state;

    private String city;

    private String district;

    private String name;

    private ZoneType zoneType;

    private String observations;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
