package com.hw_27_03.repository;

import com.hw_27_03.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionJpaRepository extends JpaRepository<Subscription,Integer> {
        Subscription findById(int id);
        Subscription findByCost(double cost);
        List<Subscription> findBySpeedBetween(double minSpeed,double maxSpeed);
        List<Subscription> findAll();
        Subscription save (Subscription subscription);
}
