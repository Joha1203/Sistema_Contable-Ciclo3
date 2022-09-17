package com.example.demo.services;

import com.example.demo.repositoris.EntityEmpresa;
import com.example.demo.repositoris.ColumnEntityEmpresa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ServiceEmpresa {

    @Autowired
    EntityEmpresa entityEmpresa;

    public List<ColumnEntityEmpresa> get() {
        var ingreso = entityEmpresa.findAll();
        log.debug("Servicio: get", ingreso);
        return ingreso;
    }

    public ColumnEntityEmpresa post(ColumnEntityEmpresa prueba) {
        var ingreso = entityEmpresa.save(prueba);
        log.debug("Servicio: Post", ingreso);
        return ingreso;
    }

    public Optional<ColumnEntityEmpresa> getEmpresa(int id) {
        var ingreso = entityEmpresa.findById(id);
        log.debug("Servicio: getEmpresa", ingreso);
        return ingreso;
    }

    public ColumnEntityEmpresa path(int id, ColumnEntityEmpresa repositorio) {
        ColumnEntityEmpresa valor = entityEmpresa.findById(id).orElse(null);
        log.debug("Servicio: path: Empresa encontrada ", valor);

        if (Objects.nonNull(valor)) {
            if (Objects.nonNull(repositorio.getId())) {
                valor.setId(repositorio.getId());
            }
            if (Objects.nonNull(repositorio.getNombre())) {
                valor.setNombre(repositorio.getNombre());
            }
            if (Objects.nonNull(repositorio.getNit())) {
                valor.setNit(repositorio.getNit());
            }
            if (Objects.nonNull(repositorio.getTelefono())) {
                valor.setTelefono(repositorio.getTelefono());
            }
            if (Objects.nonNull(repositorio.getDireccion())) {
                valor.setDireccion(repositorio.getDireccion());
            }
            log.debug("Servicio: path: Datos guardados", valor);
            return entityEmpresa.save(valor);
        }
        return repositorio;
    }

    public Optional<ColumnEntityEmpresa> delete(int id) {
        var Empresa = entityEmpresa.findById(id);
        entityEmpresa.deleteById(id);
        log.debug("Servicio: delete", Empresa);
        return Empresa;
    }


}
