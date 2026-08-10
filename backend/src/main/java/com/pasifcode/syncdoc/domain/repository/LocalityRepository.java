package com.pasifcode.syncdoc.domain.repository;

import com.pasifcode.syncdoc.domain.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, UUID> {

    List<Locality> findAllByOfficeId(UUID officeId);

    Optional<Locality> findByOfficeIdAndNameIgnoreCase(UUID officeId, String name);

    @Query("""
            SELECT COALESCE(MAX(l.sequenceNumber),0)
            FROM Locality l
            WHERE l.office.id = :officeId
            """)
    Long findLastSequenceNumber(UUID officeId);

}
