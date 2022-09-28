package com.example.demo.services;

import com.example.demo.repositoris.*;
import com.example.demo.util.DateActual;
import com.example.demo.util.DoubleConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ServiceTransaction {
    @Autowired
    RepositoryTransaction repositoryTransaction;

    @Autowired
    RepositoryEnterprise repositoryEnterprise;
    public List get(Long id){
        var lista = new ArrayList<>();
        var movimientoEmpresa = repositoryEnterprise.findById(id).orElse(new EntityEnterprise());
        var set = movimientoEmpresa.getTransactionEnterprise();
        lista.add(set);

        Double totalTransaciones = 0.0;

        if(set.size() != 0){
            for (EntityTransaction valorTransaciones: set) {
                totalTransaciones = totalTransaciones + valorTransaciones.getAmount();
            }
        }


        var valorTotal = new DoubleConversion().conversion(totalTransaciones);
        lista.add(valorTotal);

        return lista;
    }

    public void post(Long id, EntityTransaction transacion){
        var empresaDato = repositoryEnterprise.findById(id).orElse(null);
        transacion.setId_enterpriseTransaction(empresaDato);
        var fecha = new DateActual().local();
        transacion.setCreateAt(fecha);
        var ingreso = repositoryTransaction.save(transacion);
    }


    //Funciona. idea: se entra a la ruta, se muestra todas las transaciones
    // y con el boton ACTUALIZAR mandamos el id de la transaction a eliminar
    public void patch(Long id, EntityTransaction transacion){
        var valor = repositoryTransaction.findById(id).orElse(null);

        if (Objects.nonNull(valor)){
            if(Objects.nonNull(transacion.getConcept())){
                valor.setConcept(transacion.getConcept());
            }

            if (Objects.nonNull(transacion.getAmount())){
                valor.setAmount(transacion.getAmount());
            }

            var fecha = new DateActual().local();
            valor.setUpdateAt(fecha);

            repositoryTransaction.save(valor);
        }
    }

    //Funciona. idea: se entra a la ruta, se muestra todas las transaciones
    // y con el boton delete mandamos el id de la transaction a eliminar

    public EntityTransaction delete(Long id){
        var retorno = repositoryTransaction.findById(id).orElse(null);
        repositoryTransaction.deleteById(id);
        return retorno;
    }

}
