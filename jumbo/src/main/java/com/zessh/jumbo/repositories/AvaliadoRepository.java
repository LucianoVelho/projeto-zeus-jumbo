package com.zessh.jumbo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zessh.jumbo.models.entities.Avaliado;

import java.util.List;

@Repository
public interface AvaliadoRepository extends JpaRepository<Avaliado, Long> {

    @Query(value="select a from Avaliado a where a.usuario = :id")
    List<Avaliado> findAvaliadosByusuarioId (String id);
    
}
