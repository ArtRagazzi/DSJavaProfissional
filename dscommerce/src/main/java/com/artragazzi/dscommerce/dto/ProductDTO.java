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

}
