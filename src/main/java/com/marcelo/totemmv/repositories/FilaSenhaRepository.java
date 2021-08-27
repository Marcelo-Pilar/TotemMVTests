package com.marcelo.totemmv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.totemmv.domain.FilaSenha;

@Repository
public interface FilaSenhaRepository extends JpaRepository<FilaSenha, Long>  {

}
