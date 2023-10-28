package com.zessh.jumbo.controllers;

import com.zessh.jumbo.models.entities.Avaliado;
import com.zessh.jumbo.services.AvaliadoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zessh.jumbo.models.dtos.AvaliadoDTO;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/avaliados")
@PreAuthorize("hasRole('USER')")
@SecurityRequirement(name = "Bearer Authentication")
public class AvaliadoController {

    private AvaliadoService avaliadoService;

    @GetMapping("/{id}")
    public ResponseEntity<AvaliadoDTO> getAvaliadoById(@PathVariable("id") Long avaliadoId){
        AvaliadoDTO avaliadoDTO = avaliadoService.buscaAvaliado(avaliadoId);
        return new ResponseEntity<>(avaliadoDTO, HttpStatus.OK);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<AvaliadoDTO>> getAvaliadosByUsuariosId(@PathVariable("id") Long userId){
        List<AvaliadoDTO> avaliadoDTOLis = avaliadoService.buscaTodosAvaliadosPorIdUsuario(userId);
        return new ResponseEntity<>(avaliadoDTOLis, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<AvaliadoDTO> createAvaliado(@RequestBody @Valid AvaliadoDTO avaliadoDTO){
        avaliadoService.cadastraAvaliado(avaliadoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliadoDTO> updateAvaliado(@PathVariable("id") Long id, @RequestBody @Valid AvaliadoDTO avaliadoDTO){
        avaliadoService.atualizaAvaliado(avaliadoDTO, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AvaliadoDTO> deleteAvaliado(@PathVariable("id") Long id){
        avaliadoService.deletaAvaliado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
