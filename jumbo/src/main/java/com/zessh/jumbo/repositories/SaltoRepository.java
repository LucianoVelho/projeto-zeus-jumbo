package com.zessh.jumbo.repositories;

import com.zessh.jumbo.models.entities.Avaliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zessh.jumbo.models.entities.Salto;

import java.util.List;

@Repository
public interface SaltoRepository extends JpaRepository<Salto, Long> {
    @Query(value="select s from Salto s where s.avaliado.id = :id")
    List<Salto> findAvaliadosByusuarioId (Long id);
}
