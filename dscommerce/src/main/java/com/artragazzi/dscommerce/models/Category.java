package com.artragazzi.dscommerce.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "tb_category")


public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @EqualsAndHashCode.Include
    private Long id;
    @Getter @Setter
    private String name;

    @Getter
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}
