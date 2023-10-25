package com.zessh.jumbo.models.dtos;

import java.util.Date;
import java.util.List;

import com.zessh.jumbo.models.entities.Salto;
import com.zessh.jumbo.models.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliadoDTO {
    
    private String nome;

    private String sobrenome;

    private String sexo;

    private double peso;

    private double tamanho_perna_flexionada;

    private double tamanhoPernaEstendida;

    private Usuario usuario;

}
