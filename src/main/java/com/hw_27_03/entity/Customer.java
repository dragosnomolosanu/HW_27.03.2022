package com.hw_27_03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customers_details")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customer_id;
    @Column(name="customer_mobile_number")
    String phone;
    @Column(name="customer_name")
    String name;
    @Column(name="customer_adress")
    String adress;
    @Column(name="customer_type")
    String type;
    @Column(name="customer_id_proof")
    String id_proof;

    @ManyToOne
    @JoinColumn(name="subscription_id",nullable = false)
    private Subscription subscription;

    public int getCustomer_id() {
        return customer_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getType() {
        return type;
    }

    public String getId_proof() {
        return id_proof;
    }


    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId_proof(String id_proof) {
        this.id_proof = id_proof;
    }

}
