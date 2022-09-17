package com.example.demo.services;

import com.example.demo.repositoris.EntityUsers;
import com.example.demo.repositoris.ColumnEntityUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ServiceUsers {

    @Autowired
    EntityUsers entityUsers;

    public List<ColumnEntityUsers> get(){
        var ingreso = entityUsers.findAll();
        log.debug("Servicio: get",ingreso);
        return ingreso;
    }

    public ColumnEntityUsers post(ColumnEntityUsers prueba){
        var ingreso = entityUsers.save(prueba);
        log.debug("Servicio: Post",ingreso);
        return ingreso;
    }

    public Optional<ColumnEntityUsers> getPersona(int id){
        var ingreso = entityUsers.findById(id);
        log.debug("Servicio: getPersona",ingreso);
        return ingreso;
    }

    public ColumnEntityUsers path(int id, ColumnEntityUsers repositorio){
        ColumnEntityUsers valor = entityUsers.findById(id).orElse(null);
        log.debug("Servicio: path: Usuario encontrado ",valor);

        if (Objects.nonNull(valor)){
            if(Objects.nonNull(repositorio.getNombre())){
                valor.setNombre(repositorio.getNombre());
            }
            if (Objects.nonNull(repositorio.getApellido())){
                valor.setApellido(repositorio.getApellido());
            }
            if(Objects.nonNull(repositorio.getEdad())){
                valor.setEdad(repositorio.getEdad());
            }
            if (Objects.nonNull(repositorio.getDoc())){
                valor.setDoc(repositorio.getDoc());
            }
            if(Objects.nonNull(repositorio.getPassword())){
                valor.setPassword(repositorio.getPassword());
            }
            log.debug("Servicio: path: Datos guardados",valor);
            return entityUsers.save(valor);
        }
        return repositorio;
    }

    public Optional<ColumnEntityUsers> delete(int id){
        var persona = entityUsers.findById(id);
        entityUsers.deleteById(id);
        log.debug("Servicio: delete",persona);
        return persona;
    }
}
