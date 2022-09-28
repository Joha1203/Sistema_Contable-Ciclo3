package com.example.demo.repositoris;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
@Table(name = "profile")

public class EntityProfile{
    @Id
    @Column(name = "id_profile")
    @Getter
    private String id_profile;

    @Column(name = "image")
    @Getter
    private String image;

    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "lastName")
    @Getter
    private String lastName;

    @Column(name = "phone")
    @Getter
    private String phone;

    @Column(name = "createAt")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Getter
    private Date createAt;

    @Column(name = "updateAt")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Getter
    private Date updateAt;

    public EntityProfile(String id_profile, String image, String name, String lastName, String phone, Date createAt) {
        this.id_profile = id_profile;
        this.image = image;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.createAt = createAt;
    }

    public EntityProfile() {
    }

    @Override
    public String toString() {
        return "EntityProfile{" +
                "id_profile='" + id_profile + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
