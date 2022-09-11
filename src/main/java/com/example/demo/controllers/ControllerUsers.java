package com.example.demo.controllers;

import com.example.demo.repositoris.ColumnEntityUsers;
import com.example.demo.services.ServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class ControllerUsers {
    @Autowired
    ServiceUsers serviceUsers;

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getPersona(){
        return new ResponseEntity<List>(this.serviceUsers.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/post",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postPersona(@RequestBody ColumnEntityUsers repositorio){
        return new ResponseEntity<Object>(this.serviceUsers.post(repositorio), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getIdPersona(@PathVariable int id){
        return new ResponseEntity <Object>(this.serviceUsers.getPersona(id), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/path",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pathPersona(@PathVariable("id") int id, @RequestBody ColumnEntityUsers repositorio){
        return new ResponseEntity<Object>(this.serviceUsers.path(id,repositorio),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deletePersona(@PathVariable("id") int id){
        return new ResponseEntity<Object>(this.serviceUsers.delete(id),HttpStatus.OK);
    }
}
