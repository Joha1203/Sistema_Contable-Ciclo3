package com.example.demo.services;

import com.example.demo.repositoris.*;
import com.example.demo.util.EnumRol;
import com.example.demo.util.DateActual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ServiceEmployee {
    @Autowired
    RepositoryEmployee repositoryEmployee;

    @Autowired
    RepositoryTransaction repositoryTransaction;

    @Autowired
    RepositoryRol repositoryRol;

    @Autowired
    RepositoryProfile repositoryProfile;


    public List<EntityEmployee> get(){
        var datosTodos = repositoryEmployee.findAll();
        return datosTodos;
    }



    public List post(EntityEmployee employee){


        var lista = new ArrayList<>();


        var profile = employee.getProfileEmployee();
        var rol = employee.getRol();


        var admin = new EntityRol(true,true,true,true, employee);
        var operador = new EntityRol(true,true,true,false,employee);


        Date fecha = new DateActual().local();


        employee.setCreateAt(fecha);


        if(Objects.nonNull(rol) && Objects.nonNull(profile)){
            if(rol == EnumRol.Admin){
                employee.setProfileEmployee(profile);
                repositoryEmployee.save(employee);
                repositoryRol.save(admin);
            }

            if(rol == EnumRol.Operador){
                employee.setProfileEmployee(profile);
                repositoryEmployee.save(employee);
                repositoryRol.save(operador);
            }

            lista.add(repositoryEmployee.findById(employee.getId_employee()));
            return lista;
        }else{
             lista.add(new EntityEmployee("No es posible INSERTAR. revisa que los campos rol y profile no esten vacios."));
             return lista;
        }

    }

    public EntityEmployee getPersona(Long id){
        var datosPersona = repositoryEmployee.findById(id).orElse(null);

        if(Objects.nonNull(datosPersona)){
            return datosPersona;
        }else{
            datosPersona.setEmail("No es posible LEER. el id que ingresaste no existe.");
            return datosPersona;
        }
    }



    public EntityEmployee patch(Long id, EntityEmployee actualizacion){
        EntityEmployee datosActualizacion = repositoryEmployee.findById(id).orElse(null);

        if (Objects.nonNull(datosActualizacion)){

            if (Objects.nonNull(actualizacion.getEmail())){
                datosActualizacion.setEmail(actualizacion.getEmail());
            }

            if (Objects.nonNull(actualizacion.getPassword())){
                datosActualizacion.setEmail(actualizacion.getPassword());
            }

            if (Objects.nonNull(actualizacion.getRol())){
                datosActualizacion.setRol(actualizacion.getRol());
                var rol = actualizacion.getRol();

                if(rol == EnumRol.Admin){
                    var idRol = datosActualizacion.getId_employee();
                    var nuevoRol = repositoryRol.findById(idRol+1).orElse(null);

                    if(nuevoRol != null){
                        nuevoRol.setBorrar(true);
                        repositoryRol.save(nuevoRol);
                    }

                }else if(rol == EnumRol.Operador){
                    var idRol = datosActualizacion.getId_employee();
                    var nuevoRol = repositoryRol.findById(idRol+1).orElse(null);

                    if(nuevoRol != null){
                        nuevoRol.setBorrar(false);
                        repositoryRol.save(nuevoRol);
                    }

                }

            }


            if(Objects.nonNull(actualizacion.getProfileEmployee())){
                datosActualizacion.setProfileEmployee(actualizacion.getProfileEmployee());
            }

            var fecha = new DateActual().local();
            datosActualizacion.setUpdateAt(fecha);


            return repositoryEmployee.save(datosActualizacion);

        }else{
            datosActualizacion.setEmail("No fue posible ACTUALIZAR. trabajador no encontrado");
            return  datosActualizacion;
        }
    }


    public void delete(Long id){
        var usuarioEliminar = repositoryEmployee.findById(id).orElse(null);
        var id_profile = usuarioEliminar.getProfileEmployee().getId_profile();

        if(Objects.nonNull(usuarioEliminar)){

            usuarioEliminar.setProfileEmployee(null);
            repositoryEmployee.save(usuarioEliminar);
            repositoryEmployee.deleteById(id);
            repositoryProfile.deleteById(id_profile);
        }
    }

    public void nuevoEmpleado(Long id,EntityEmployee trabajador){
        var adminDato = repositoryEmployee.findById(id).orElse(null);
        var lista = new ArrayList<>();
        if (adminDato.getRol() == EnumRol.Admin){
            trabajador.setId_enterpriseEmployee(adminDato.getId_enterpriseEmployee());
            this.post(trabajador);
        }
    }

}

