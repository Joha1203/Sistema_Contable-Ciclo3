package com.example.demo.repositoris;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "persona")
public class PruebaRepositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Apellido")
    private String Apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "password")
    private String password;
    @Column(name = "doc")
    private String doc;
    @Column(name = "edad")
    private Integer edad;



}
