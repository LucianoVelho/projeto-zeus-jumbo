package com.zessh.jumbo.models.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
public class Avaliado implements Serializable{

    public static final String TABLE_NAME = "avaliado";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
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
    private double tamanho_perna_flexionada;

    @Column(name = "tamanho_perna_estendida", nullable = false)
    private double tamanhoPernaEstendida;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
}
