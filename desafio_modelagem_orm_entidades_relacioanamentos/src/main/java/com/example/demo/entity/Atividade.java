package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;

    @ManyToMany(mappedBy = "atividades")
    private List<Participante> participantes = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    //A tabela tb_atividade terá uma coluna id_categoria como chave estrangeira.


    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL)
    private List<Bloco> blocos = new ArrayList<>();
}
