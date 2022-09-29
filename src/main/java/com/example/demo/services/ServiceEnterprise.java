package com.example.demo.services;

import com.example.demo.repositoris.EntityEmployee;
import com.example.demo.repositoris.EntityEnterprise;
import com.example.demo.repositoris.RepositoryEmployee;
import com.example.demo.repositoris.RepositoryEnterprise;
import com.example.demo.util.DateActual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ServiceEnterprise {
    @Autowired
    RepositoryEnterprise repositoryEnterprise;

    @Autowired
    RepositoryEmployee repositoryEmployee;

    public List<EntityEnterprise> get() {
        var ingreso = repositoryEnterprise.findAll();
        return ingreso;
    }


    public EntityEnterprise post(EntityEnterprise Enterprise) {
        Date fecha = new DateActual().local();
        Enterprise.setCreateAt(fecha);

        var ingreso = repositoryEnterprise.save(Enterprise);
        return ingreso;
    }

    public Optional<EntityEnterprise> getEnterprise(Long id) {
        var ingreso = repositoryEnterprise.findById(id);
        return ingreso;
    }

    public void patch(Long id, EntityEnterprise repositorio) {
        EntityEnterprise valor = repositoryEnterprise.findById(id).orElse(null);

        if (Objects.nonNull(valor)) {
            if (Objects.nonNull(repositorio.getName())) {
                valor.setName(repositorio.getName());
            }
            if (Objects.nonNull(repositorio.getDocument())) {
                valor.setDocument(repositorio.getDocument());
            }
            if (Objects.nonNull(repositorio.getPhone())) {
                valor.setPhone(repositorio.getPhone());
            }
            if (Objects.nonNull(repositorio.getAddress())) {
                valor.setAddress(repositorio.getAddress());
            }

            var fecha = new DateActual().local();
            valor.setUpdateAt(fecha);
            repositoryEnterprise.save(valor);
        }

    }

    public void delete(Long id) {
        var empresa = repositoryEnterprise.findById(id).orElse(null);

        if(Objects.nonNull(empresa)){
            repositoryEnterprise.deleteById(id);
        }
    }

    public void trabajadorEmpresa(Long id, EntityEmployee trabajador){
        var empresa = repositoryEnterprise.findById(id).orElse(null);
        trabajador.setId_enterpriseEmployee(empresa);
        repositoryEmployee.save(trabajador);
    }
}