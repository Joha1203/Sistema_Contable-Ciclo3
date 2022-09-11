package com.example.demo.services;

import com.example.demo.repositoris.EntityEmpresa;
import com.example.demo.repositoris.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmpresa {

    @Autowired
    EntityEmpresa entityEmpresa;

    public List<EmpresaRepositorio> get(){
        var ingreso = entityEmpresa.findAll();
        return ingreso;
    }

    public EmpresaRepositorio post(EmpresaRepositorio prueba){
        var ingreso = entityEmpresa.save(prueba);
        return ingreso;
    }

    public EmpresaRepositorio path(int id, EmpresaRepositorio repositorio){
        EmpresaRepositorio valor = entityEmpresa.findById(id).orElse(null);

        if (repositorio.getNombre() != null){
            valor.setId(repositorio.getId());
            valor.setNombre(repositorio.getNombre());
            valor.setNit(repositorio.getNit());
            valor.setTelefono(repositorio.getTelefono());
            valor.setDireccion(repositorio.getDireccion());
        }

        return entityEmpresa.save(valor);
    }

    public Optional<EmpresaRepositorio> delete(int id){
        var empresa = entityEmpresa.findById(id);
        entityEmpresa.deleteById(id);
        return empresa;
    }
}
