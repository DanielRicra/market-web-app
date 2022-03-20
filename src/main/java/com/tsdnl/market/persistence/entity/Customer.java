package com.tsdnl.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String lastNames;

    @Column(name = "celular")
    private Double cellphone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String emailAddress;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public Double getCellphone() {
        return cellphone;
    }

    public void setCellphone(Double cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
