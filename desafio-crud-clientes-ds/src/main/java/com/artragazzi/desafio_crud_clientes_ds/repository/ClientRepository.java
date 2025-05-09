package com.artragazzi.desafio_crud_clientes_ds.repository;

import com.artragazzi.desafio_crud_clientes_ds.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
