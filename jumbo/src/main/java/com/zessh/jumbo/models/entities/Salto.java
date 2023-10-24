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
public class Salto implements Serializable {

     public static final String TABLE_NAME = "salto";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
    private Long id;  

    @Column(name = "altura_salto", nullable = false)
    private double alturaSalto;

    @Column(name = "tempo_voo", nullable = true)
    private String tempoVoo;

    @Column(name = "forca_media", nullable = false)
    private String forcaMedia;

    @Column(name = "potencia_media", nullable = false)
    private String potenciaMedia;

    @Column(name = "velocidade_media", nullable = false)
    private String velocidadeMedia;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "avaliado_id")
    private Avaliado avaliado;
    
}
