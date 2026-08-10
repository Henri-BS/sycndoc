package com.pasifcode.syncdoc.init;

import com.pasifcode.syncdoc.domain.entity.*;
import com.pasifcode.syncdoc.domain.enums.*;
import com.pasifcode.syncdoc.domain.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@SpringBootApplication
public class StartApplication {


    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Bean
    CommandLineRunner seedDatabase(
            OfficeRepository officeRepository,
            PersonRepository personRepository,
            LocalityRepository localityRepository,
            AddressRepository addressRepository,
            ContactRepository contactRepository,
            UserRepository userRepository,
            @Lazy
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            Office office = officeRepository.findByAcronym("SSA")
                    .orElseGet(() -> officeRepository.save(Office.builder()
                            .name("Escritório Silva & Associados")
                            .acronym("SSA")
                            .cnpj("12345678000199")
                            .email("contato@silvaassociados.com.br")
                            .website("https://silvaassociados.com.br")
                            .active(true)
                            .build()));

            if (userRepository.findByEmail("admin@syncdoc.com") == null) {
                userRepository.save(User.builder()
                        .username("admin")
                        .email("admin@syncdoc.com")
                        .password(passwordEncoder.encode("12345678"))
                        .userRoles(UserRoles.ADMIN)
                        .build());
            }

            Person person = personRepository.findAllByOfficeId(office.getId()).stream()
                    .filter(p -> "João da Silva Testemunha".equals(p.getName()))
                    .findFirst()
                    .orElseGet(() -> personRepository.save(Person.builder()
                            .office(office)
                            .sequenceNumber(personRepository.findLastSequenceNumber(office.getId()) + 1)
                            .name("João da Silva Testemunha")
                            .cpf("12345678900")
                            .role(PersonRole.TESTEMUNHA)
                            .gender(Gender.MALE)
                            .birthDate(LocalDate.of(1990, 5, 14))
                            .maritalStatus(MaritalStatus.SINGLE)
                            .profession("Engenheiro Civil")
                            .build()));

            Locality locality = localityRepository.findByOfficeIdAndNameIgnoreCase(office.getId(), "Centro de Caxias")
                    .orElseGet(() -> localityRepository.save(Locality.builder()
                            .office(office)
                            .sequenceNumber(localityRepository.findLastSequenceNumber(office.getId()) + 1)
                            .country("Brasil")
                            .state("Maranhão")
                            .city("Caxias")
                            .district("Centro")
                            .name("Centro de Caxias")
                            .zoneType(ZoneType.URBAN)
                            .active(true)
                            .build()));

            if (addressRepository.findAllByPersonId(person.getId()).isEmpty()) {
                addressRepository.save(Address.builder()
                        .person(person)
                        .locality(locality)
                        .sequenceNumber(addressRepository.findLastSequenceNumber(person.getId()) + 1)
                        .number("123")
                        .complement("Apto 45, Bloco B")
                        .active(true)
                        .build());
            }

            if (contactRepository.findAllByPersonId(person.getId()).isEmpty()) {
                contactRepository.save(Contact.builder()
                        .office(office)
                        .person(person)
                        .sequenceNumber(1L)
                        .platform(ContactPlatform.WHATSAPP)
                        .value("(98) 99999-9999")
                        .primaryContact(true)
                        .active(true)
                        .build());
            }
        };
    }
}