package com.zessh.jumbo.models.mappers;

import java.time.LocalDate;

import com.zessh.jumbo.models.dtos.KeycloakUserDTO;
import com.zessh.jumbo.models.dtos.UsuarioTokenDTO;
import org.mapstruct.Mapper;

import com.zessh.jumbo.models.dtos.UsuarioDTO;
import com.zessh.jumbo.models.entities.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapperImpl {
    
    public Usuario toEntityUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDataCadastro(LocalDate.now());
        return usuario;
    }
    public UsuarioTokenDTO toUsuarioTokenDTO(KeycloakUserDTO usuarioDTO, String token){
        UsuarioTokenDTO tokenDTO = new UsuarioTokenDTO();
        tokenDTO.setNome(usuarioDTO.getFirstName());
        tokenDTO.setSobrenome(usuarioDTO.getLastName());
        tokenDTO.setEmail(usuarioDTO.getEmail());
        tokenDTO.setToken(token);
        tokenDTO.setId(usuarioDTO.getId());
        return tokenDTO;
    }
}
