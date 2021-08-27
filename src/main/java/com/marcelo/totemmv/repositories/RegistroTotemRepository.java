package com.marcelo.totemmv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.totemmv.domain.RegistroTotem;

@Repository
public interface RegistroTotemRepository extends JpaRepository<RegistroTotem, Long>{

}
