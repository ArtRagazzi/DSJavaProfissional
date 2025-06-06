package com.artragazzi.desafio_crud_clientes_ds.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FieldMessage {

    private String fieldName;
    private String message;
}
