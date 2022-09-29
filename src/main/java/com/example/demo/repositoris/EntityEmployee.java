package com.example.demo.repositoris;


import com.example.demo.util.EnumRol;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Table(name = "employee")

public class EntityEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee")
    @Getter
    private Long id_employee;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    @Getter
    private EnumRol rol;

    @Column(name = "email",unique = true)
    @Getter
    private String email;

    @Column(name = "password")
    @Getter
    private String password;

    @Column(name = "createAt")
    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createAt;

    @Column(name = "updateAt")
    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_profileEmployee",referencedColumnName = "id_profile")
    private EntityProfile profileEmployee;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id_EmployeeTransaction")
    @OrderBy(value = "id_EmployeeTransaction asc")
    private Set<EntityTransaction> transactionEmployee;

    @ManyToOne()
    @JoinColumn(name = "id_enterpriseEmployee",referencedColumnName = "id_enterprise")
    private EntityEnterprise id_enterpriseEmployee;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id_employeeRol")
    @OrderBy(value = "id_employeeRol asc")
    private Set<EntityRol> rolEmployee;


    public EntityProfile getProfileEmployee() {
        return profileEmployee;
    }

    public Set<EntityTransaction> getTransactionEmployee() {
        return transactionEmployee;
    }

    public Set<EntityRol> getRolEmployee() {
        return rolEmployee;
    }

    @JsonBackReference
    public EntityEnterprise getId_enterpriseEmployee() {
        return id_enterpriseEmployee;
    }

    public EntityEmployee(EnumRol rol, String email, String password, Date createAt, Date updateAt, EntityProfile profileEmployee, EntityEnterprise id_enterpriseEmployee) {
        this.rol = rol;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.profileEmployee = profileEmployee;
        this.id_enterpriseEmployee = id_enterpriseEmployee;
    }


    public EntityEmployee() {
    }

    public EntityEmployee(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EntityEmployee{" +
                "id_employee=" + id_employee +
                ", rol=" + rol +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", profileEmployee=" + profileEmployee +
                ", transactionEmployee=" + transactionEmployee +
                ", id_enterpriseEmployee=" + id_enterpriseEmployee +
                ", rolEmployee=" + rolEmployee +
                '}';
    }
}
