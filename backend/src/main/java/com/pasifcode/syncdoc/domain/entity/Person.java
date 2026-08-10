package com.pasifcode.syncdoc.domain.entity;

import com.pasifcode.syncdoc.domain.enums.Gender;
import com.pasifcode.syncdoc.domain.enums.MaritalStatus;
import com.pasifcode.syncdoc.domain.enums.PersonRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_person")
public class Person extends BaseEntity {

    @Column(nullable = false)
    private Long sequenceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @Column(nullable = false)
    private String name;

    @Column(length = 14)
    private String cpf;

    @Column(length = 18)
    private String cnpj;

    private LocalDate birthDate;

    private String profession;

    @Column(length = 20)
    private String rgNumber;

    private LocalDate rgIssueDate;

    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private MaritalStatus maritalStatus;

    private String fatherName;

    private LocalDate fatherBirthDate;

    private String motherName;

    private LocalDate motherBirthDate;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Contact> contacts = new ArrayList<>();

}