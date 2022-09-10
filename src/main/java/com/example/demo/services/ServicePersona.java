package com.example.demo.services;


import com.example.demo.repositoris.EntityPersona;
import com.example.demo.repositoris.PruebaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePersona {

    @Autowired
    EntityPersona entityPersona;

    public List<PruebaRepositorio> get(){
        var ingreso = entityPersona.findAll();
        return ingreso;
    }

    public PruebaRepositorio post(PruebaRepositorio prueba){
        var ingreso = entityPersona.save(prueba);
        return ingreso;
    }

    public PruebaRepositorio path(int id, PruebaRepositorio repositorio){
        PruebaRepositorio valor = entityPersona.findById(id).orElse(null);

        if (repositorio.getNombre() != null){
            valor.setNombre(repositorio.getNombre());
            valor.setApellido(repositorio.getApellido());
            valor.setEdad(repositorio.getEdad());
            valor.setDoc(repositorio.getDoc());
            valor.setPassword(repositorio.getPassword());
        }

        return entityPersona.save(valor);
    }

    public Optional<PruebaRepositorio> delete(int id){
        var persona = entityPersona.findById(id);
        entityPersona.deleteById(id);
        return persona;
    }

}
