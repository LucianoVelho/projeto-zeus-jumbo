package com.zessh.jumpo.services;

import com.zessh.jumpo.models.dtos.SaltoDTO;
import com.zessh.jumpo.models.entities.Salto;
import com.zessh.jumpo.models.mappers.SaltoMapperImpl;
import com.zessh.jumpo.repositories.AvaliadoRepository;
import com.zessh.jumpo.repositories.SaltoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SaltoService {

    private SaltoRepository saltoRepository;

    private SaltoMapperImpl saltoMapper;

    private AvaliadoRepository avaliadoRepository;
    public SaltoDTO buscaSalto(Long id) {
        SaltoDTO saltoDTO = saltoMapper.toDTOSalto(saltoRepository.getReferenceById(id));
        saltoDTO.setAvaliado(id);
        return saltoDTO;
    }

    public List<SaltoDTO> buscaTodosSaltoPorIdAvaliado(Long avaliadoId) {
        List<SaltoDTO> saltoDTOList = new ArrayList<>();
        List<Salto> saltos = saltoRepository.findAvaliadosByusuarioId(avaliadoId);
        for( Salto salto:saltos){
            SaltoDTO saltoDTO = saltoMapper.toDTOSalto(salto);
            saltoDTO.setAvaliado(avaliadoId);
            saltoDTOList.add(saltoDTO);
        }
        return saltoDTOList;
    }

    public void cadastraSalto(SaltoDTO saltoDTO) {
        Salto salto = saltoMapper.toEntitySalto(saltoDTO);
        salto.setAvaliado(avaliadoRepository.getReferenceById(saltoDTO.getAvaliado()));
        saltoRepository.save(salto);
    }

    public void deletaSalto(Long id) {
        saltoRepository.deleteById(id);
    }
}
