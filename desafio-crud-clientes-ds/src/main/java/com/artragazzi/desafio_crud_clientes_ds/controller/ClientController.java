package com.artragazzi.desafio_crud_clientes_ds.controller;


import com.artragazzi.desafio_crud_clientes_ds.dto.ClientRequestDTO;
import com.artragazzi.desafio_crud_clientes_ds.dto.ClientResponseDTO;
import com.artragazzi.desafio_crud_clientes_ds.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findByid(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(clientService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> insert (@Valid @RequestBody ClientRequestDTO clientRequestDTO){
        ClientResponseDTO responseDTO = clientService.insert(clientRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ClientRequestDTO clientRequestDTO){
        ClientResponseDTO clientResponseDTO = clientService.update(id, clientRequestDTO);
        return ResponseEntity.ok(clientResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
