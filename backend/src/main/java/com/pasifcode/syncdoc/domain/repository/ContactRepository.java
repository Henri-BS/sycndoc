package com.pasifcode.syncdoc.domain.repository;

import com.pasifcode.syncdoc.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {

    List<Contact> findAllByPersonId(UUID personId);

    @Query("""
       SELECT COALESCE(MAX(a.sequenceNumber),0)
       FROM Address a
       WHERE a.person.id = :personId
       """)
    Long findLastSequenceNumber(UUID personId);

}
