package com.zessh.jumbo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zessh.jumbo.models.entities.Salto;

@Repository
public interface SaltoRepository extends JpaRepository<Salto, Long> {
    
}
