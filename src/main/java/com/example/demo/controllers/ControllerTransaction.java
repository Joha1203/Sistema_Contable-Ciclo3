package com.example.demo.controllers;

import com.example.demo.repositoris.EntityTransaction;
import com.example.demo.services.ServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Set;

@Controller
@RequestMapping(value = "/enterprises")
public class ControllerTransaction {

    @Autowired
    ServiceTransaction serviceTransaction;

    //obtener movimientos: funciona
    @GetMapping(path = "/{id}/movements/get")
    public String getEnterprise(Model model,@PathVariable("id") Long id){
        var lista  = serviceTransaction.get(id);
        var transaciones = lista.get(0);
        var total = lista.get(1);
        model.addAttribute("listEmployees", transaciones);
        model.addAttribute("ruta",id);
        model.addAttribute("cantidad",total);
        return "movimientoEmpresa";
    }

    //obtener plantilla y crear movimiento: funciona
    @GetMapping(path = "/{id}/movements/crear")
    public String postMovimiento(Model modelo,@PathVariable("id") Long ruta){
        modelo.addAttribute("Epersona", new EntityTransaction() );
        modelo.addAttribute("ruta",ruta);
        return "crearMovimiento";
    }

    @PostMapping(path = "/{idRuta}/movements/post")
    public RedirectView postMovimiento(Model modelo,@PathVariable("idRuta") Long ruta,@ModelAttribute EntityTransaction transaccion){
        modelo.addAttribute(transaccion);
        serviceTransaction.post(ruta,transaccion);
        String url = "/enterprises/%s/movements/get".formatted(ruta);
        return new RedirectView(url);
    }


    //obtener plantilla y actualizar:funciona
    @GetMapping(path = "/{idRuta}/movements/actualizar/{idTransaction}")
    public String formMovimiento(Model modelo,@PathVariable("idRuta") Long ruta, @PathVariable("idTransaction") Long transacion){
        modelo.addAttribute("Epersona", new EntityTransaction() );
        modelo.addAttribute("ruta",ruta);
        modelo.addAttribute("idTransacion",transacion);
        return "actualizarMovimiento";
    }

    @PostMapping(path = "/{idRuta}/movements/patch/{idTransaction}")
    public RedirectView patchMovimiento(Model modelo, @PathVariable("idRuta") Long ruta, @ModelAttribute EntityTransaction transaction,@PathVariable("idTransaction") Long idTransaction){
        modelo.addAttribute(transaction);
        serviceTransaction.patch(idTransaction,transaction);
        String url = "/enterprises/%s/movements/get".formatted(ruta);
        return new RedirectView(url);
    }


    //Eliminar transacion: funciona
    @PostMapping(path ="/{idRuta}/movements/delete/{id}")
    public RedirectView deleteMovimiento( @PathVariable("id") Long id, @PathVariable("idRuta") Long ruta){
        serviceTransaction.delete(id);
        String url = "/enterprises/%s/movements/get".formatted(ruta);
        return new RedirectView(url);
    }
}
