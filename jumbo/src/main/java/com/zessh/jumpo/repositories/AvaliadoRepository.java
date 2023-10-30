package com.zessh.jumpo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zessh.jumpo.models.entities.Avaliado;

import java.util.List;

@Repository
public interface AvaliadoRepository extends JpaRepository<Avaliado, Long> {

    @Query(value="select a from Avaliado a where a.usuario.id = :id")
    List<Avaliado> findAvaliadosByusuarioId (Long id);
    
}
