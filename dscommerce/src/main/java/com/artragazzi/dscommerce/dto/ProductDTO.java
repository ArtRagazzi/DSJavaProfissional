package com.artragazzi.dscommerce.dto;

import com.artragazzi.dscommerce.models.Product;

public record ProductDTO(Long id, String name, String description, Double price, String imgUrl) {

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
