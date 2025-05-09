package com.artragazzi.desafio_crud_clientes_ds.service.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }
}
