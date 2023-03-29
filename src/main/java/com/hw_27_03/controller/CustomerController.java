package com.hw_27_03.controller;

import com.hw_27_03.entity.Customer;
import com.hw_27_03.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/byId/{id}")
    public Customer getCustomerById(@PathVariable(value="id") int id){
        return customerService.getById(id);
    }


//    @GetMapping("/byName/{name}")
//    public List<Customer> getByName(@PathVariable(value="name") String name){
//        return customerService.getByName(name);
//    }

    @PutMapping("/updateAdress/{id}/{adress}")
    public Integer updateAdress(@PathVariable int id,@PathVariable String adress){
        return customerService.updateCustomerAdress(id,adress);
    }


}
