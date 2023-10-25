package com.zessh.jumbo.services;

import com.zessh.jumbo.models.dtos.AvaliadoDTO;
import com.zessh.jumbo.models.entities.Avaliado;
import com.zessh.jumbo.models.mappers.AvaliadosMapperImpl;
import com.zessh.jumbo.repositories.AvaliadoRepository;
import com.zessh.jumbo.repositories.UsuarioRepositoty;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AvaliadoService {

    private UsuarioRepositoty usuarioRepositoty;

    private AvaliadoRepository avaliadoRepository;

    private AvaliadosMapperImpl avaliadosMapper;
    public void cadastraAvaliado(AvaliadoDTO avaliadoDTO){
        Avaliado avaliado = avaliadosMapper.toEntityAvaliado(avaliadoDTO);
        avaliado.setUsuario(usuarioRepositoty.getReferenceById(avaliadoDTO.getUsuario()));
        avaliadoRepository.save(avaliado);
    }

    public AvaliadoDTO buscaAvaliado(Long id){
        Avaliado avaliado = avaliadoRepository.getReferenceById(id);
        AvaliadoDTO avaliadoDTO = avaliadosMapper.toDTOAvaliado(avaliado);
        return avaliadoDTO;
    }

    public List<AvaliadoDTO> buscaTodosAvaliadosPorIdUsuario(Long id){
        List<AvaliadoDTO> avaliadoDTOList = new ArrayList<>();
        List<Avaliado> avaliados = avaliadoRepository.findAvaliadosByusuarioId(id);
        for(Avaliado a : avaliados){
            AvaliadoDTO dto = avaliadosMapper.toDTOAvaliado(a);
            dto.setUsuario(id);
            avaliadoDTOList.add(dto);
        }
        return avaliadoDTOList;
    }

    public void atualizaAvaliado(AvaliadoDTO dto, Long id){
        Avaliado recursoExistente = avaliadoRepository.getReferenceById(id);
        BeanUtils.copyProperties(dto, recursoExistente, "id");
        avaliadoRepository.save(recursoExistente);
    }

    public void deletaAvaliado(Long id){
        avaliadoRepository.deleteById(id);
    }
    
}
