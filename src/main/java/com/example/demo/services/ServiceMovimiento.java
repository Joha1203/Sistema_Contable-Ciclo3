package com.example.demo.services;

import com.example.demo.repositoris.EntityMovimiento;
import com.example.demo.repositoris.ColumnEntityMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Objects;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ServiceMovimiento {
    @Autowired
    EntityMovimiento entityMovimiento;

    public List<ColumnEntityMovimiento> get(){
        var ingreso = entityMovimiento.findAll();
        log.debug("Servicio: get",ingreso);
        return ingreso;
    }

    public ColumnEntityMovimiento post(int id, ColumnEntityMovimiento prueba){
        var ingreso = entityMovimiento.save(prueba);
        log.debug("Servicio: Post",ingreso);
        return ingreso;
    }

    public Optional<ColumnEntityMovimiento> getMovimiento(int id){
        var ingreso = entityMovimiento.findById(id);
        log.debug("Servicio: getMovimiento",ingreso);
        return ingreso;
    }

    public ColumnEntityMovimiento path(int id, ColumnEntityMovimiento repositorio){
        ColumnEntityMovimiento valor = entityMovimiento.findById(id).orElse(null);
        log.debug("Servicio: path: Movimiento encontrado ",valor);

        if (Objects.nonNull(valor)){
            if(Objects.nonNull(repositorio.getConcepto())){
                valor.setConcepto(repositorio.getConcepto());
            }
            if (Objects.nonNull(repositorio.getMonto())){
                valor.setMonto(repositorio.getMonto());
            }
            if(Objects.nonNull(repositorio.getUsuario())){
                valor.setUsuario(repositorio.getUsuario());
            }
            if (Objects.nonNull(repositorio.getEmpresa())){
                valor.setEmpresa(repositorio.getEmpresa());
            }
            log.debug("Servicio: path: Datos guardados",valor);
            return entityMovimiento.save(valor);
        }
        return repositorio;
    }

    public Optional<ColumnEntityMovimiento> delete(int id){
        var movimiento = entityMovimiento.findById(id);
        entityMovimiento.deleteById(id);
        log.debug("Servicio: delete",movimiento);
        return movimiento;
    }

}
