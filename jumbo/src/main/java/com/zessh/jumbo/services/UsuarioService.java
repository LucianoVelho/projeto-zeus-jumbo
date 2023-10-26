package com.zessh.jumbo.services;

import com.zessh.jumbo.models.entities.Usuario;
import com.zessh.jumbo.repositories.AvaliadoRepository;
import org.springframework.stereotype.Service;

import com.zessh.jumbo.models.dtos.UsuarioDTO;
import com.zessh.jumbo.models.mappers.UsuarioMapperImpl;
import com.zessh.jumbo.repositories.UsuarioRepositoty;

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
