package com.artragazzi.dscommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @EqualsAndHashCode.Include
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    @Column(unique = true)
    private String email;
    @Getter @Setter
    private String phone;
    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private String password;

    //Qual o nome do Atributo la na cLasse Order
    @Getter
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
}
