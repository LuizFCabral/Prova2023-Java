package com.fatec.projetojava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.projetojava.entities.Empresa;
import com.fatec.projetojava.repositories.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> getEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    // usado no remover 
    public Empresa getEmpresaById(int id){
        return empresaRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Empresa não encontrado")
        );
    }

    public void deleteEmpresa(int id){
        Empresa empresa = getEmpresaById(id);
        empresaRepository.delete(empresa);
    }

}
