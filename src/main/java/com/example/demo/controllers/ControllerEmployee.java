package com.example.demo.controllers;

import com.example.demo.repositoris.EntityEmployee;
import com.example.demo.services.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/users")

public class ControllerEmployee {
    @Autowired
    ServiceEmployee serviceEmployee;

    //Traer todos los trabajadores:funciona
    @GetMapping(path = "/get")
    public String getPersona(Model modelo){
        var valor = serviceEmployee.get();
        modelo.addAttribute("listEmployees", valor);
        return "trabajadores";
    }


    //obtener plantilla y crear usuario:funciona
    @GetMapping(path = "/crear")
    public String postPersona(Model modelo){
        modelo.addAttribute("Epersona",new EntityEmployee());
        return "crearTrabajador";
    }

    @PostMapping(path = "/post")
    public RedirectView postPersona(Model modelo, @ModelAttribute EntityEmployee trabajador){
        modelo.addAttribute(trabajador);
        serviceEmployee.post(trabajador);
        String url = "/users/get";
        return new RedirectView(url);
    }



    //obtener plantilla y actualizar
    @GetMapping(path = "/{idRuta}/actualizar")
    public String getIdPersona(Model modelo,@PathVariable("idRuta") Long ruta){
        modelo.addAttribute("Epersona",new EntityEmployee());
        modelo.addAttribute("ruta",ruta);
        return "actualizarTrabajador";
    }

    @PostMapping(path = "/{idRuta}/patch")
    public RedirectView  pathPersona(Model modelo, @PathVariable("idRuta") Long ruta, @ModelAttribute EntityEmployee trabajador){
        modelo.addAttribute(trabajador);
        serviceEmployee.patch(ruta,trabajador);
        String url = "/users/get";
        return new RedirectView(url);
    }

    //eliminar usuario:funciona
    @PostMapping(path = "/{idRuta}/delete")
    public RedirectView deletePersona(@PathVariable("idRuta") Long ruta){
        serviceEmployee.delete(ruta);
        String url = "/users/get";
        return new RedirectView(url);
    }

    @PostMapping(path = "/{idRuta}/delete2")
    public RedirectView deleteTrabajador(@PathVariable("idRuta") Long ruta){
        serviceEmployee.delete(ruta);
        String url = "/enterprises/%s/get".formatted(ruta);
        return new RedirectView(url);
    }


}
