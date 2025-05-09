package com.artragazzi.desafio_crud_clientes_ds.dto;

import com.artragazzi.desafio_crud_clientes_ds.model.Client;

public record ClientResponseDTO (Long id, String name, String cpf, Double income){

    public static ClientResponseDTO toResponseDTO(Client entity){
        return new ClientResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getIncome()
        );
    }
}
