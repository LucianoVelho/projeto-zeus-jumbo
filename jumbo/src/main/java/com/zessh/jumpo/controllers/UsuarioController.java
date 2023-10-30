package com.zessh.jumpo.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zessh.jumpo.models.dtos.UsuarioDTO;
import com.zessh.jumpo.services.UsuarioService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody @Valid UsuarioDTO usuarioDTO){
        usuarioService.criaUsuario(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
