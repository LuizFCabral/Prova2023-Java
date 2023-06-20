package com.fatec.projetojava.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.projetojava.entities.Empresa;
import com.fatec.projetojava.services.EmpresaService;

@RestController
@RequestMapping("empresas")
@CrossOrigin
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;
    
    @PostMapping
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa){
        Empresa empresaSalvo = empresaService.save(empresa);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(empresa.getId())
                .toUri();

        return ResponseEntity.created(location).body(empresaSalvo);
    }
}