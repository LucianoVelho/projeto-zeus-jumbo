package com.zessh.jumbo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zessh.jumbo.models.dtos.EsqueceuDTO;
import com.zessh.jumbo.models.dtos.LoginDTO;
import com.zessh.jumbo.services.KeycloakService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zessh.jumbo.models.dtos.UsuarioDTO;
import com.zessh.jumbo.services.UsuarioService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;
    private KeycloakService keycloakService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO){
        return usuarioService.login(loginDTO);
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody @Valid UsuarioDTO usuarioDTO) throws JsonProcessingException {
        usuarioService.criaUsuario(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/esqueceu")
    public ResponseEntity<String> esqueceuSenha(@RequestBody @Valid EsqueceuDTO esqueceuDTO) throws JsonProcessingException {
        usuarioService.esqueceuASenha(esqueceuDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
