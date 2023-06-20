package com.fatec.projetojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.projetojava.entities.Empresa;

public interface EmpresaRepository extends JpaRepository <Empresa, Integer>{
    
}
