package com.zessh.jumpo.models.mappers;

import com.zessh.jumpo.models.dtos.AvaliadoDTO;
import com.zessh.jumpo.models.entities.Avaliado;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;

import java.time.LocalDate;
@AllArgsConstructor
@Mapper(componentModel = "spring")
public abstract  class AvaliadosMapperImpl {

    public Avaliado toEntityAvaliado(AvaliadoDTO avaliadoDTO){
        Avaliado avaliado = new Avaliado();
        avaliado.setNome(avaliadoDTO.getNome());
        avaliado.setSobrenome(avaliadoDTO.getSobrenome());
        avaliado.setSexo(avaliadoDTO.getSexo());
        avaliado.setPeso(avaliadoDTO.getPeso());
        avaliado.setDataCadastro(LocalDate.now());
        avaliado.setTamanhoPernaEstendida(avaliadoDTO.getTamanhoPernaEstendida());
        return avaliado;
    }
    public AvaliadoDTO toDTOAvaliado(Avaliado avaliado){
        AvaliadoDTO avaliadoDTO = new AvaliadoDTO();
        avaliadoDTO.setNome(avaliado.getNome());
        avaliadoDTO.setSobrenome(avaliado.getSobrenome());
        avaliadoDTO.setSexo(avaliado.getSexo());
        avaliadoDTO.setPeso(avaliado.getPeso());
        avaliadoDTO.setTamanhoPernaEstendida(avaliado.getTamanhoPernaEstendida());
        return avaliadoDTO;
    }
    
}
