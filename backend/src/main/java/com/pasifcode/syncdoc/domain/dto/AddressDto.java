package com.pasifcode.syncdoc.domain.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    private UUID localityId;

    private Long sequenceNumber;

    private UUID personId;

    private String number;

    private String complement;

    private Double latitude;

    private Double longitude;

    private String directLink;

    private Boolean active;
}