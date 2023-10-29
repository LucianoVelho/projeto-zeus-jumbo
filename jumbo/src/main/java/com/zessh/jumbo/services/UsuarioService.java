package com.zessh.jumbo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zessh.jumbo.models.dtos.*;
import com.zessh.jumbo.models.entities.Usuario;
import org.springframework.stereotype.Service;

import com.zessh.jumbo.models.mappers.UsuarioMapperImpl;
import com.zessh.jumbo.repositories.UsuarioRepositoty;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioMapperImpl usuarioMapperImpl;
    private KeycloakService keycloakService;

    public UsuarioTokenDTO login(LoginDTO loginDTO) throws JsonProcessingException {
        String userId = keycloakService.getUserId(loginDTO.getEmail());
        KeycloakUserDTO keycloakUserDTO = keycloakService.getUserInfo(userId);
        String token = keycloakService.getToken(loginDTO.getEmail(),loginDTO.getSenha());
       return usuarioMapperImpl.toUsuarioTokenDTO(keycloakUserDTO,token);
    }

    public void criaUsuario(UsuarioDTO usuarioDTO) throws JsonProcessingException {
        keycloakService.createUser(usuarioDTO.getEmail(), usuarioDTO.getNome(),
                usuarioDTO.getSobrenome(), usuarioDTO.getEmail(), usuarioDTO.getSenha());
    }

    public void esqueceuASenha(EsqueceuDTO esqueceuDTO) throws JsonProcessingException {
        String userID = keycloakService.getUserId(esqueceuDTO.getEmail());
        keycloakService.updatePassword(userID, esqueceuDTO.getNovaSenha());
    }

    public void isUsuario(String idUsuario) throws JsonProcessingException {
        keycloakService.isUser(idUsuario);
    }
}
