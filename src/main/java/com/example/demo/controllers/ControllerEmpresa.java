package com.example.demo.controllers;


import com.example.demo.repositoris.EmpresaRepositorio;
import com.example.demo.services.ServiceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/categories")

public class ControllerEmpresa {

    @Autowired
    ServiceEmpresa serviceEmpresa;

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getEmpresa(){
        return new ResponseEntity(this.serviceEmpresa.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postEmpresa(@RequestBody EmpresaRepositorio repositorio){
        return new ResponseEntity(this.serviceEmpresa.post(repositorio), HttpStatus.OK);
    }

    @PatchMapping(path = "/path/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity pathEmpresa(@PathVariable("id") int id, @RequestBody EmpresaRepositorio repositorio){
        return new ResponseEntity(this.serviceEmpresa.path(id,repositorio),HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteEmpresa(@PathVariable("id") int id){
        return new ResponseEntity(this.serviceEmpresa.delete(id),HttpStatus.OK);
    }
}

