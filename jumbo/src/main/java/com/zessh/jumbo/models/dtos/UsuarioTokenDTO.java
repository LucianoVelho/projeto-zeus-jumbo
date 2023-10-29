package com.zessh.jumbo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioTokenDTO {
    private String email;
    private String nome;
    private String sobrenome;
    private String token;
    private String id;
}
