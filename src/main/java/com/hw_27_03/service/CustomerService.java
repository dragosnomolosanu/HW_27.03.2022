package com.hw_27_03.service;

import com.hw_27_03.entity.Customer;
import com.hw_27_03.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerJpaRepository customerJpaRepository;

    @Autowired
    public CustomerService(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    public Customer getById(int id){
        return customerJpaRepository.findById(id);
    }

    public List<Customer> getAllCustomers(){
        return customerJpaRepository.findAll();
    }

    public List<Customer> getByName(String name){
        return customerJpaRepository.findByName(name);
    }

//    public void Insert(String adress, String id_proof,String name,String mobile,String type,int subscriptionid){
//       customerJpaRepository.insertCustomer(adress,id_proof,name,mobile,type,subscriptionid);
//    }
    public Integer updateCustomerAdress(int id,String adress){
        return customerJpaRepository.updateAdress(id,adress);
    }

}
