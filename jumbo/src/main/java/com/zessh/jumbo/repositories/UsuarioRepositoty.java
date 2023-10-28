package com.zessh.jumbo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zessh.jumbo.models.entities.Usuario;

@Repository
public interface UsuarioRepositoty extends JpaRepository<Usuario, Long>{

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha")
    boolean existsByEmailAndSenha(@Param("nome") String nome, @Param("senha") String senha);
    
}
