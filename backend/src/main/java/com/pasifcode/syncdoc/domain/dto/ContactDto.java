package com.pasifcode.syncdoc.domain.dto;

import com.pasifcode.syncdoc.domain.enums.ContactPlatform;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ContactDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    private Long sequenceNumber;

    private UUID personId;

    private ContactPlatform platform;

    private String value;

    private Boolean primaryContact;

    private String label;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
