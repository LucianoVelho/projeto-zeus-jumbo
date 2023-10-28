package com.zessh.jumbo.controllers;

import com.zessh.jumbo.models.dtos.SaltoDTO;
import com.zessh.jumbo.services.SaltoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/saltos")
@PreAuthorize("hasRole('USER')")
@SecurityRequirement(name = "Bearer Authentication")
public class SaltoController {

    private SaltoService saltoService;

    @GetMapping("/{id}")
    public ResponseEntity<SaltoDTO> getSaltoById(@PathVariable("id") Long id){
        SaltoDTO saltoDto = saltoService.buscaSalto(id);
        return new ResponseEntity<>(saltoDto, HttpStatus.OK);
    }
    @GetMapping("/avaliado/{id}")
    public ResponseEntity<List<SaltoDTO>> getSaltosByAvaliadoId(@PathVariable("id") Long avaliadoId){
        List<SaltoDTO> saltoDTOList = saltoService.buscaTodosSaltoPorIdAvaliado(avaliadoId);
        return new ResponseEntity<>(saltoDTOList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SaltoDTO> createSalto(@RequestBody @Valid SaltoDTO saltoDTO){
        saltoService.cadastraSalto(saltoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SaltoDTO> deleteSalto(@PathVariable("id") Long id){
        saltoService.deletaSalto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
