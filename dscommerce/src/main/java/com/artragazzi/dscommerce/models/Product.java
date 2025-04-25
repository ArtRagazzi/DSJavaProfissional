package com.artragazzi.dscommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @EqualsAndHashCode.Include
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @Column(columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    private String imgUrl;

    @Getter
    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @Getter
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();


    public List<Order> getOrders(){
        return items.stream().map(x-> x.getOrder()).toList();
    }
}
