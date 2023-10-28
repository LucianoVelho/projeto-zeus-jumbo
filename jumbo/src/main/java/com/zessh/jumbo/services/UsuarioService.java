package com.zessh.jumbo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zessh.jumbo.models.dtos.EsqueceuDTO;
import com.zessh.jumbo.models.dtos.LoginDTO;
import com.zessh.jumbo.models.entities.Usuario;
import org.springframework.http.ResponseEntity;
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
    private KeycloakService keycloakService;

    public ResponseEntity<String> login(LoginDTO loginDTO){
       return keycloakService.getToken(loginDTO.getEmail(), loginDTO.getSenha());
    }

    public void criaUsuario(UsuarioDTO usuarioDTO) throws JsonProcessingException {

        Usuario usuaruio = usuarioMapperImpl.toEntityUsuario(usuarioDTO);
        usuarioRepositoty.save(usuaruio);
        keycloakService.createUser(usuaruio.getEmail(), usuaruio.getNome(),
                usuaruio.getSobrenome(), usuaruio.getEmail(), usuaruio.getSenha());

    }

    public void esqueceuASenha(EsqueceuDTO esqueceuDTO) throws JsonProcessingException {
        String userID = keycloakService.getUserId(esqueceuDTO.getEmail());
        keycloakService.updatePassword(userID, esqueceuDTO.getNovaSenha());
    }
}
