package com.example.demo.controllers;



import com.example.demo.repositoris.PruebaRepositorio;
import com.example.demo.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(value = "/Rest")
public class ControllerPersona {
    @Autowired
    ServicePersona servicePersona;

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPersona(){
        return new ResponseEntity(this.servicePersona.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postPersona(@RequestBody PruebaRepositorio repositorio){
        return new ResponseEntity(this.servicePersona.post(repositorio), HttpStatus.OK);
    }

    @PatchMapping(path = "/path/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity pathPersona(@PathVariable("id") int id, @RequestBody PruebaRepositorio repositorio){
        return new ResponseEntity(this.servicePersona.path(id,repositorio),HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePersona(@PathVariable("id") int id){
        return new ResponseEntity(this.servicePersona.delete(id),HttpStatus.OK);
    }
}