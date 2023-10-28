package com.zessh.jumbo.models.dtos;

import java.util.Date;
import java.util.List;

import com.zessh.jumbo.models.entities.Salto;
import com.zessh.jumbo.models.entities.Usuario;

import com.zessh.jumbo.validation.usuarioid.ValidUsuarioId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliadoDTO {

    @NotBlank(message = "Nome Inválido: Nome Vazio")
    @NotNull(message = "Nome Inválido: Nome é NULO")
    @Size(min = 3, max = 30, message = "Nome Inválido: Deve conter de 3 a 30 caracteres")
    private String nome;

    @NotBlank(message = "Sobrenome Inválido: Sobrenome Vazio")
    @NotNull(message = "Sobrenome Inválido: Sobrenome é NULO")
    @Size(min = 3, max = 30, message = "Sobrenome Inválido: Deve conter de 3 a 30 caracteres")
    private String sobrenome;

    @NotBlank(message = "Sexo Inválido: Sexo Vazio")
    @NotNull(message = "Sexo Inválido: Sexo é NULO")
    private String sexo;

    @Positive(message = "O peso deve ser um valor positivo")
    private double peso;

    private double tamanhoPernaFlexionada;

    @Positive(message = "O tamanho da perna estendida deve ser um valor positivo")
    private double tamanhoPernaEstendida;

    private Long usuario;

}
