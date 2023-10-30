package com.zessh.jumpo.models.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Avaliado.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avaliado implements Serializable{

    public static final String TABLE_NAME = "avaliado";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = true)
    private String sobrenome;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "tamanho_perna_flexionada", nullable = false)
    private double tamanhoPernaFlexionada;

    @Column(name = "tamanho_perna_estendida", nullable = false)
    private double tamanhoPernaEstendida;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    
}
