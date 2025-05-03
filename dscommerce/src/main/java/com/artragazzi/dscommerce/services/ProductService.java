package com.artragazzi.dscommerce.services;

import com.artragazzi.dscommerce.dto.ProductDTO;
import com.artragazzi.dscommerce.models.Product;
import com.artragazzi.dscommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository =productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).get();
        return ProductDTO.toDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductDTO::toDTO);
    }

    @Transactional()
    public ProductDTO insert(ProductDTO productDTO){
        Product entity = ProductDTO.toEntity(productDTO);
        entity = productRepository.save(entity);
        return ProductDTO.toDTO(entity);
    }

    @Transactional()
    public ProductDTO update(Long id, ProductDTO productDTO){
        Product entity = productRepository.getReferenceById(id);
        copyDtoToEntity(productDTO,entity);
        entity = productRepository.save(entity);
        return ProductDTO.toDTO(entity);
    }


    private void copyDtoToEntity(ProductDTO dto, Product product){
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setImgUrl(dto.imgUrl());
    }
}
