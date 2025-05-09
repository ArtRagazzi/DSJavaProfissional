package com.artragazzi.desafio_crud_clientes_ds.service;

import com.artragazzi.desafio_crud_clientes_ds.dto.ClientRequestDTO;
import com.artragazzi.desafio_crud_clientes_ds.dto.ClientResponseDTO;
import com.artragazzi.desafio_crud_clientes_ds.model.Client;
import com.artragazzi.desafio_crud_clientes_ds.repository.ClientRepository;
import com.artragazzi.desafio_crud_clientes_ds.service.exceptions.DatabaseException;
import com.artragazzi.desafio_crud_clientes_ds.service.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Transactional(readOnly = true)
    public ClientResponseDTO findByid(Long id){
        Client entity = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Client não encontrado!"));
        return ClientResponseDTO.toResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ClientResponseDTO> findAll(Pageable pageable){
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(ClientResponseDTO::toResponseDTO);
    }

    @Transactional
    public ClientResponseDTO insert(ClientRequestDTO requestDTO){
         Client entity = ClientRequestDTO.toEntity(requestDTO);
         entity = clientRepository.save(entity);
         return ClientResponseDTO.toResponseDTO(entity);
    }

    @Transactional
    public ClientResponseDTO update(Long id, ClientRequestDTO requestDTO){
        try{
            //Exception EntityNotFound e lançada aqui
            Client entity = clientRepository.getReferenceById(id);
            //
            copyRequestDtoTOEntity(requestDTO, entity);
            entity = clientRepository.save(entity);
            return ClientResponseDTO.toResponseDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFound("Client não encontrado!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFound("Cliente não encontrado");
        }
        try{
            clientRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }

    }


    private void copyRequestDtoTOEntity(ClientRequestDTO dto, Client entity){
        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setIncome(dto.income());
        entity.setChildren(dto.children());
        entity.setBirthDate(dto.birthDate());
    }


}
