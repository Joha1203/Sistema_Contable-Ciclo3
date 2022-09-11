package com.example.demo.repositoris;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empresa")
public class ColumnEntityEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nit")
    private String nit;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;


}
