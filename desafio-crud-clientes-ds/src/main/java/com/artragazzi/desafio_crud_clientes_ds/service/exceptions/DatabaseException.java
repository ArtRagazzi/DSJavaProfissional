package com.artragazzi.desafio_crud_clientes_ds.service.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}
