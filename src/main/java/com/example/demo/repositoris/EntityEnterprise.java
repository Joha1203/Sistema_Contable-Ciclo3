package com.example.demo.repositoris;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Table(name = "enterprise")

public class EntityEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_enterprise")
    @OrderBy(value = "id_enterprise asc")
    @Getter
    private Long id_enterprise;

    @Column(name = "name",unique = true)
    @Getter
    private String name;

    @Column(name = "document",unique = true)
    @Getter
    private String document;

    @Column(name = "phone")
    @Getter
    private String phone;

    @Column(name = "address")
    @Getter
    private String address;

    @Column(name = "createAt")
    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createAt;

    @Column(name = "updateAt")
    @Getter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id_enterpriseEmployee")
    @OrderBy(value = "id_enterpriseEmployee asc")
    private Set<EntityEmployee> employeeEnterprise;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = EntityTransaction.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id",referencedColumnName = "id_enterprise")
    @OrderBy(value = "id_transaction asc")
    private Set<EntityTransaction> transactionEnterprise;

    public Set<EntityEmployee> getEmployeeEnterprise() {
        return employeeEnterprise;
    }

    public Set<EntityTransaction> getTransactionEnterprise() {
        return transactionEnterprise;
    }

    public EntityEnterprise(String name, String document, String phone, String address, Date createAt, Date updateAt) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public EntityEnterprise() {
    }

    public EntityEnterprise(String name) {
        this.name = name;
    }
}
