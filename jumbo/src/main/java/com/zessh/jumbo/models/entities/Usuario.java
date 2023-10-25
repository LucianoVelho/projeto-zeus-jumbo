package com.zessh.jumbo.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Usuario.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    public static final String TABLE_NAME = "usuario";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = true)
    private String senha;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

}
