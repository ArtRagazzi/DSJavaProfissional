package com.artragazzi.desafio_crud_clientes_ds.dto;

import com.artragazzi.desafio_crud_clientes_ds.model.Client;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientRequestDTO(

        @NotNull(message = "Nome não pode ser vazio")
        String name,
        String cpf,
        Double income,
        @PastOrPresent(message = "Não pode ser data futura")
        LocalDate birthDate,
        Integer children

){


    public static Client toEntity(ClientRequestDTO clientRequestDTO){
        Client entity = new Client();
        entity.setName(clientRequestDTO.name());
        entity.setCpf(clientRequestDTO.cpf());
        entity.setIncome(clientRequestDTO.income());
        entity.setChildren(clientRequestDTO.children());
        entity.setBirthDate(clientRequestDTO.birthDate());
        return entity;
    }

}
