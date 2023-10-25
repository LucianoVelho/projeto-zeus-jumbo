package com.zessh.jumbo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zessh.jumbo.models.dtos.AvaliadoDTO;
import com.zessh.jumbo.models.dtos.UsuarioDTO;
import com.zessh.jumbo.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.criaUsuario(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
