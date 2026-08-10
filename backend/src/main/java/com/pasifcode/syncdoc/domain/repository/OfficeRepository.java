package com.pasifcode.syncdoc.domain.repository;

import com.pasifcode.syncdoc.domain.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository<Office, UUID> {

    Optional<Office> findByAcronym(String acronym);

    boolean existsByAcronym(String acronym);

    boolean existsByCnpj(String cnpj);
}