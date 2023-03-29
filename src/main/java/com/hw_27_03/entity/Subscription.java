package com.hw_27_03.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int subscription_id;
    @Column(name="subscription_cost")
    double cost;
    @Column(name="subscription_details")
    String detalis;
    @Column(name="subscription_area")
    double area;
    @Column(name="subscription_speed")
    double speed;

    @OneToMany(mappedBy = "subscription")
    private Set<Customer> customers;

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDetalis() {
        return detalis;
    }

    public void setDetalis(String detalis) {
        this.detalis = detalis;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
