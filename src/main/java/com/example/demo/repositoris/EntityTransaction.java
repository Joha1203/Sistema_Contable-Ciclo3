package com.example.demo.repositoris;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Table(name = "transaction")

public class EntityTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    @Getter
    private Long id_transaction;

    @Column(name = "concept")
    @Getter
    private String concept;

    @Column(name = "amount")
    @Getter
    private Double amount;

    @ManyToOne()
    @JoinColumn(name = "id_EmployeeTransaction",referencedColumnName = "id_employee")
    @OrderBy(value = "id_employee asc")
    private EntityEmployee id_EmployeeTransaction;


    @ManyToOne()
    @JoinColumn(name = "enterprise_id",referencedColumnName = "id_enterprise")
    @OrderBy(value = "id_enterprise asc")
    private EntityEnterprise id_enterpriseTransaction;

    @Column(name = "createAt")
    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createAt;

    @Column(name = "updateAt")
    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    @JsonBackReference(value = "id_EmployeeTransaction")
    public EntityEmployee getId_Employee() {
        return id_EmployeeTransaction;
    }

    @JsonBackReference(value = "id_enterpriseTransaction")
    public EntityEnterprise getId_enterprise() {
        return id_enterpriseTransaction;
    }

    public EntityTransaction(String concept, Double amount, Date updateAt) {
        this.concept = concept;
        this.amount = amount;
        this.updateAt = updateAt;
    }

    public EntityTransaction(EntityEnterprise id_enterpriseTransaction) {
        this.id_enterpriseTransaction = id_enterpriseTransaction;
    }

    public EntityTransaction(EntityEmployee id_EmployeeTransaction) {
        this.id_EmployeeTransaction = id_EmployeeTransaction;
    }

    public EntityTransaction(String concept, Double amount, EntityEmployee id_EmployeeTransaction, EntityEnterprise id_enterpriseTransaction, Date createAt) {
        this.concept = concept;
        this.amount = amount;
        this.id_EmployeeTransaction = id_EmployeeTransaction;
        this.id_enterpriseTransaction = id_enterpriseTransaction;
        this.createAt = createAt;
    }

    public EntityTransaction() {
    }

    public EntityTransaction(String concept) {
        this.concept = concept;
    }
}




