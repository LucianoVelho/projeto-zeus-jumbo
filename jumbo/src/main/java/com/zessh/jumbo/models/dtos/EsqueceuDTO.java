package com.zessh.jumbo.models.dtos;

import com.zessh.jumbo.validation.password.ValidPassword;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EsqueceuDTO {

    @Email
    private String email;

    @ValidPassword
    private String novaSenha;
}
