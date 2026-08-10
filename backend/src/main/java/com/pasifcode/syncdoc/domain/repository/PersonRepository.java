package com.pasifcode.syncdoc.domain.repository;

import com.pasifcode.syncdoc.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    List<Person> findAllByOfficeId(UUID officeId);

    @Query("""
           SELECT COALESCE(MAX(p.sequenceNumber), 0)
           FROM Person p
           WHERE p.office.id = :officeId
           """)
    Long findLastSequenceNumber(UUID officeId);

    boolean existsByOfficeIdAndCpf(
            UUID officeId,
            String cpf
    );

    boolean existsByOfficeIdAndCnpj(
            UUID officeId,
            String cnpj
    );

}