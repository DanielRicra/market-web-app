package com.tsdnl.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String id;

    @Column(name = "nombres")
    private String names;

    @Column(name = "apellidos")
    private String lastNames;

    @Column(name = "celular")
    private Double cellphone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String emailAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return names;
    }

    public void setName(String names) {
        this.names = names;
    }

    public String getLastName() {
        return lastNames;
    }

    public void setLastName(String lastNames) {
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
