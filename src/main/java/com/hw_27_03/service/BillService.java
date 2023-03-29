package com.hw_27_03.service;

import com.hw_27_03.entity.Bill;

import com.hw_27_03.repository.BillJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BillService {
    @Autowired
    BillJpaRepository billJpaRepository;

    @Autowired
    public BillService(BillJpaRepository billJpaRepository) {
        this.billJpaRepository = billJpaRepository;
    }

    public List<Bill> getBillByCost(double cost){
        return billJpaRepository.findByCost(cost);
    }
    public Bill getById(int id){
        return billJpaRepository.findById(id);
    }
}
