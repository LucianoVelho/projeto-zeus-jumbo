package com.zessh.jumpo.services;

import com.zessh.jumpo.models.entities.Usuario;
import org.springframework.stereotype.Service;

import com.zessh.jumpo.models.dtos.UsuarioDTO;
import com.zessh.jumpo.models.mappers.UsuarioMapperImpl;
import com.zessh.jumpo.repositories.UsuarioRepositoty;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    
    private UsuarioRepositoty usuarioRepositoty;
    private UsuarioMapperImpl usuarioMapperImpl;

    public void criaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuaruio = usuarioMapperImpl.toEntityUsuario(usuarioDTO);
        usuarioRepositoty.save(usuaruio);
    }
}
