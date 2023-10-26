package com.zessh.jumbo.models.dtos;

import java.util.Date;

import com.zessh.jumbo.models.entities.Avaliado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaltoDTO {
    
    private double alturaSalto;

    private double tempoVoo;

    private double forcaMedia;

    private double potenciaMedia;
   
    private double velocidadeMedia;

    private double dataCadastro;

    private Long avaliado;

}
