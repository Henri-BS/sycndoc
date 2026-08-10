package com.pasifcode.syncdoc.domain.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class OfficeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    private String name;

    private String acronym;

    private String cnpj;

    private String email;

    private String website;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
