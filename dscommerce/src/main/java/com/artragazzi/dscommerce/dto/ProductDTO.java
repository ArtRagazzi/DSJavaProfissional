package com.artragazzi.dscommerce.dto;

import com.artragazzi.dscommerce.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDTO(
        Long id,

        @Size(min = 3, max = 80, message = "Tamanho minimo: 3 e Maximo: 80")
        @NotBlank(message = "Campo obrigatorio")
        String name,
        @NotBlank(message = "Campo obrigatorio")
        @Size(min = 10, message = "Minimo 10 Caracteres")
        String description,
        @Positive(message = "O preço deve ser positivo!")
        Double price,
        String imgUrl
) {

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(
             product.getId(),
             product.getName(),
             product.getDescription(),
             product.getPrice(),
             product.getImgUrl()
        );
    }

    public static Product toEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        product.setImgUrl(productDTO.imgUrl());
        return product;
    }

}
