package com.hw_27_03.service;

import com.hw_27_03.entity.Subscription;
import com.hw_27_03.repository.SubscriptionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubscriptionService {
    @Autowired
    SubscriptionJpaRepository subscriptionJpaRepository;

    @Autowired
    public SubscriptionService(SubscriptionJpaRepository subscriptionJpaRepository) {
        this.subscriptionJpaRepository=subscriptionJpaRepository;
    }

    public Subscription getById(int id){
        return subscriptionJpaRepository.findById(id);
    }

    public Subscription getByCost(double cost){
        return subscriptionJpaRepository.findByCost(cost);
    }
    public List<Subscription> getSubscriptions(){
        return subscriptionJpaRepository.findAll();
    }

    public List<Subscription> findBySpeedBetween(double minSpeed,double maxSpeed){
        return subscriptionJpaRepository.findBySpeedBetween(minSpeed,maxSpeed);
    }
}
