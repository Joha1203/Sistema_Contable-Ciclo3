package com.example.demo.controllers;

import com.example.demo.repositoris.EntityEmployee;
import com.example.demo.repositoris.EntityEnterprise;
import com.example.demo.services.ServiceEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping(value = "/enterprises")

public class ControllerEnterprise {
    @Autowired
    ServiceEnterprise serviceEnterprise;


    //traer todas las empresas: funciona
    @GetMapping(path = "/get")
    public String getEnterprise(Model modelo){
        modelo.addAttribute("listEmployees", serviceEnterprise.get());
        return "empresas";
    }


    //obtener plantilla y crear empresa : funciona
    @GetMapping(path = "/crear")
    public String postEnterprise(Model modelo){
        modelo.addAttribute("Epersona", new EntityEnterprise() );
        return "crearEmpresa";
    }

    @PostMapping(path = "/post")
    public RedirectView postEnterprise(Model modelo, @ModelAttribute EntityEnterprise empresa){
        modelo.addAttribute(empresa);
        serviceEnterprise.post(empresa);
        String url = "/enterprises/get";
        return new RedirectView(url);
    }


    //traer los trabajadores de dicha empresa :funciona
    @GetMapping(path = "/{id}/get")
    public String getIdEnterprise(Model modelo,@PathVariable Long id){
        var empresa = serviceEnterprise.getEnterprise(id).orElse( null);
        var lista = empresa.getEmployeeEnterprise();
        modelo.addAttribute("listEmployees", lista);
        modelo.addAttribute("ruta",id);
        return "trabajadoresEmpresa";
    }

    //traer plantilla y actualizar: funciona

    @GetMapping(path = "/{idRuta}/actualizar")
    public String actualizarEnterprise(Model modelo,@PathVariable("idRuta") Long ruta){
        modelo.addAttribute("Epersona", new EntityEnterprise() );
        modelo.addAttribute("ruta",ruta);
        return "actualizarEmpresa";
    }

    @PostMapping(path = "/{idRuta}/patch")
    public RedirectView pathEnterprise(Model modelo,@PathVariable("idRuta") Long ruta, @ModelAttribute EntityEnterprise empresa){
        modelo.addAttribute(empresa);
        serviceEnterprise.patch(ruta,empresa);
        String url = "/enterprises/get";
        return new RedirectView(url);
    }


    //eliminar empresa : funciona
    @PostMapping(path = "/{idRuta}/delete")
    public RedirectView deleteEnterprise(Model modelo,@PathVariable("idRuta") Long id){
        serviceEnterprise.delete(id);
        String url = "/enterprises/get";
        return new RedirectView(url);
    }

    @GetMapping(path = "/{idEmpresa}/crearTrabajadorEmpresa")
    public String crearTrabajadorEmpresa(Model modelo,@PathVariable("idEmpresa") Long ruta){
        modelo.addAttribute("Epersona", new EntityEmployee());
        modelo.addAttribute("ruta",ruta);
        return "crearTrabajadorEmpresa";
    }

    @PostMapping(path = "/{idEmpresa}/postTrabajadorEmpresa")
    public RedirectView post(Model modelo,@PathVariable("idEmpresa") Long ruta, @ModelAttribute EntityEmployee trabajador){
        System.out.println(ruta);
        System.out.println(trabajador);
        serviceEnterprise.trabajadorEmpresa(ruta,trabajador);
        String url = "/enterprises/%s/get".formatted(ruta);
        return new RedirectView(url);
    }

}

