package com.hw_27_03.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bill_no;

    Date month;
    double cost;
    String status;
    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="subscription_id",nullable = false)
    private Subscription subscription;

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
