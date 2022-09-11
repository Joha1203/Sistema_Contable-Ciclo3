package com.example.demo.controllers;

import com.example.demo.repositoris.ColumnEntityEmpresa;
import com.example.demo.services.ServiceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/enterprises")

public class ControllerEmpresa {
    @Autowired
    ServiceEmpresa serviceEmpresa;

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getEmpresa(){
        return new ResponseEntity<List>(this.serviceEmpresa.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postEmpresa(@RequestBody ColumnEntityEmpresa repositorio){
        return new ResponseEntity<Object>(this.serviceEmpresa.post(repositorio), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getIdEmpresa(@PathVariable int id){
        return new ResponseEntity <Object>(this.serviceEmpresa.getEmpresa(id), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/path",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pathEmpresa(@PathVariable("id") int id, @RequestBody ColumnEntityEmpresa repositorio){
        return new ResponseEntity<Object>(this.serviceEmpresa.path(id,repositorio),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteEmpresa(@PathVariable("id") int id){
        return new ResponseEntity<Object>(this.serviceEmpresa.delete(id),HttpStatus.OK);
    }

}

