package com.example.demo.repositoris;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movimiento")
public class ColumnEntityMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "monto")
    private String monto;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "empresa")
    private String empresa;

}



