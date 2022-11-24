package com.example.secondmainproject.Dao.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "form")
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;


    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;




    public FormEntity(String name, String lastname, String phone, String email, String date, String time) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.time = time;

    }

    public FormEntity() {
    }

}
