package com.fatec.projetojava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.projetojava.entities.Empresa;
import com.fatec.projetojava.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

}
