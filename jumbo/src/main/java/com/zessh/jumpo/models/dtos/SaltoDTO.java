package com.zessh.jumpo.models.dtos;

import com.zessh.jumpo.validation.avaliadoid.ValidAvaliadoId;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaltoDTO {

    @Positive(message = "A altura do salto deve ser um valor positivo")
    private double alturaSalto;

    @Positive(message = "O tempo de voo deve ser um valor positivo")
    private double tempoVoo;

    @Positive(message = "A força média deve ser um valor positivo")
    private double forcaMedia;

    @Positive(message = "A potência média deve ser um valor positivo")
    private double potenciaMedia;

    @Positive(message = "A velocidade média deve ser um valor positivo")
    private double velocidadeMedia;

    @ValidAvaliadoId
    private Long avaliado;

}
