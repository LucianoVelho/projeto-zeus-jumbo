package com.zessh.jumbo.models.dtos;

import com.zessh.jumbo.validation.password.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    @Email(message = "Email inválido")
    private String email;

    @ValidPassword
    private String senha;

    @NotBlank(message = "Nome Inválido: Nome Vazio")
    @NotNull(message = "Nome Inválido: Nome é NULO")
    @Size(min = 3, max = 30, message = "Nome Inválido: Deve conter de 3 a 30 caracteres")
    private String nome;

    @NotBlank(message = "Sobrenome Inválido: Sobrenome Vazio")
    @NotNull(message = "Sobrenome Inválido: Sobrenome é NULO")
    @Size(min = 3, max = 30, message = "Sobrenome Inválido: Deve conter de 3 a 30 caracteres")
    private String sobrenome;
}
