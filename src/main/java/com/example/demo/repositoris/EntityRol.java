package com.example.demo.repositoris;


import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Table(name = "rol")
public class EntityRol{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rol")
    @Getter
    private Long id_rol;

    @Getter
    @Column(name = "lectura")
    private Boolean lectura;

    @Getter
    @Column(name = "escritura")
    private Boolean escritura;

    @Getter
    @Column(name = "actualizacion")
    private Boolean actualizacion;

    @Getter
    @Column(name = "borrar")
    private Boolean borrar;

    @JoinColumn(name = "id_employeeRol",referencedColumnName = "id_employee")
    @ManyToOne(optional = false)
    private EntityEmployee id_employeeRol;

    @JsonBackReference
    public EntityEmployee getId_employeeRol() {
        return id_employeeRol;
    }

    public EntityRol(Boolean lectura, Boolean escritura, Boolean actualizacion, Boolean borrar, EntityEmployee id_employeeRol) {
        this.lectura = lectura;
        this.escritura = escritura;
        this.actualizacion = actualizacion;
        this.borrar = borrar;
        this.id_employeeRol = id_employeeRol;
    }

    public EntityRol() {
    }
}

