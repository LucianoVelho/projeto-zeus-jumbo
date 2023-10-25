package com.zessh.jumbo.models.mappers;

import java.time.LocalDate;

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
}
