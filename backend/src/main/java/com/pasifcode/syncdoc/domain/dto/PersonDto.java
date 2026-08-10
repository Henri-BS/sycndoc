package com.pasifcode.syncdoc.domain.dto;

import com.pasifcode.syncdoc.domain.enums.Gender;
import com.pasifcode.syncdoc.domain.enums.MaritalStatus;
import com.pasifcode.syncdoc.domain.enums.PersonRole;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PersonDto implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private UUID id;
        private Long sequenceNumber;
        private String name;
        private String cpf;
        private String cnpj;
        private LocalDate birthDate;
        private PersonRole role;
        private Gender gender;
        private MaritalStatus maritalStatus;
        private String profession;
        private String rgNumber;
        private LocalDate rgIssueDate;
        private String fatherName;
        private LocalDate fatherBirthDate;
        private String motherName;
        private LocalDate motherBirthDate;
        private AddressDto address;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
