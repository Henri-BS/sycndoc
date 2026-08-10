package com.pasifcode.syncdoc.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_office")
public class Office extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Pattern(
            regexp = "^[A-Z]{3}$",
            message = "A sigla deve conter exatamente 3 letras maiúsculas"
    )
    @Column(nullable = false, unique = true, length = 3)
    private String acronym;

    @Column(length = 18)
    private String cnpj;

    private String email;

    private String website;

    @Column(nullable = false)
    private Boolean active;

}
