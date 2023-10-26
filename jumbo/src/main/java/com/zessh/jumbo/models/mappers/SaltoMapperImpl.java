package com.zessh.jumbo.models.mappers;

import com.zessh.jumbo.models.dtos.AvaliadoDTO;
import com.zessh.jumbo.models.dtos.SaltoDTO;
import com.zessh.jumbo.models.entities.Avaliado;
import com.zessh.jumbo.models.entities.Salto;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public abstract class SaltoMapperImpl {

    public Salto toEntitySalto(SaltoDTO saltoDTO){
        Salto salto = new Salto();
        salto.setAlturaSalto(saltoDTO.getAlturaSalto());
        salto.setForcaMedia(saltoDTO.getForcaMedia());
        salto.setPotenciaMedia(saltoDTO.getPotenciaMedia());
        salto.setTempoVoo(salto.getTempoVoo());
        salto.setVelocidadeMedia(saltoDTO.getVelocidadeMedia());
        salto.setDataCadastro(LocalDate.now());
        return salto;
    }
    public SaltoDTO toDTOSalto(Salto salto){
        SaltoDTO saltoDTO = new SaltoDTO();
        saltoDTO.setAlturaSalto(salto.getAlturaSalto());
        saltoDTO.setForcaMedia(salto.getForcaMedia());
        saltoDTO.setPotenciaMedia(salto.getPotenciaMedia());
        saltoDTO.setTempoVoo(saltoDTO.getTempoVoo());
        saltoDTO.setVelocidadeMedia(salto.getVelocidadeMedia());
        return saltoDTO;
    }
    
}
