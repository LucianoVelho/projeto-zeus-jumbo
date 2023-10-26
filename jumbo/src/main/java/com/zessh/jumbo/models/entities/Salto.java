package com.zessh.jumbo.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = Salto.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salto implements Serializable {

    public static final String TABLE_NAME = "salto";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  

    @Column(name = "altura_salto", nullable = false)
    private double alturaSalto;

    @Column(name = "tempo_voo", nullable = false)
    private double tempoVoo;

    @Column(name = "forca_media", nullable = false)
    private double forcaMedia;

    @Column(name = "potencia_media", nullable = false)
    private double potenciaMedia;

    @Column(name = "velocidade_media", nullable = false)
    private double velocidadeMedia;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "avaliado_id")
    private Avaliado avaliado;
    
}
