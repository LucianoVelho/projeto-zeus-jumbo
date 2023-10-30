package com.zessh.jumpo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zessh.jumpo.models.entities.Usuario;

@Repository
public interface UsuarioRepositoty extends JpaRepository<Usuario, Long>{
    
}
