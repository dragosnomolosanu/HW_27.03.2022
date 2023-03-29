package com.hw_27_03.controller;

import com.hw_27_03.dto.SpeedsBetweenDTO;
import com.hw_27_03.entity.Subscription;
import com.hw_27_03.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    SubscriptionService subscriptionService;
    Logger logger= LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/allSubscriptions")
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.getSubscriptions();
    }

    @GetMapping("byId/{id}")
    public Subscription getById(@PathVariable(value="id") int id){
        return subscriptionService.getById(id);
    }

    @GetMapping("byCost/{cost}")
    public Subscription getByCost(@PathVariable(value="cost") double cost){
        return subscriptionService.getByCost(cost);
    }
    @GetMapping("/speeds")
    public ResponseEntity<List<Subscription>> getBySpeedBetween(@RequestBody SpeedsBetweenDTO speedsBetweenDTO){
        logger.info("Receive the following DTO:"+speedsBetweenDTO);
        List<Subscription> subscriptions=subscriptionService.findBySpeedBetween(speedsBetweenDTO.getMinSpeed(),speedsBetweenDTO.getMaxSpeed());
        return new ResponseEntity<List<Subscription>>(subscriptions, HttpStatus.OK);
    }

}
