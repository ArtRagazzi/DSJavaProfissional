package com.artragazzi.dscommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_category")


public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;

    @Getter
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}
