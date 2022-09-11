package com.example.demo.controllers;

import com.example.demo.repositoris.ColumnEntityMovimiento;
import com.example.demo.services.ServiceMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/enterprises")
public class ControllerMovimiento {
    @Autowired
    ServiceMovimiento serviceMovimiento;

    @GetMapping(path = "/{id}/movements/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMovimiento(){
        return new ResponseEntity(this.serviceMovimiento.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/movements/post",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postMovimiento(@PathVariable("id") int id,@RequestBody ColumnEntityMovimiento repositorio){
        return new ResponseEntity(this.serviceMovimiento.post(id,repositorio), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/movements/path",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity pathMovimiento(@PathVariable("id") int id,@RequestBody ColumnEntityMovimiento repositorio){
        return new ResponseEntity(this.serviceMovimiento.path(id,repositorio),HttpStatus.OK);
    }

    @DeleteMapping(path ="/{id}/movements/delete",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMovimiento(@PathVariable("id") int id){
        return new ResponseEntity(this.serviceMovimiento.delete(id),HttpStatus.OK);
    }
}
