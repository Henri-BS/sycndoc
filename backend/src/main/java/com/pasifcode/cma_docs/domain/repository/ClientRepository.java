package com.pasifcode.cma_docs.domain.repository;

import com.pasifcode.cma_docs.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
