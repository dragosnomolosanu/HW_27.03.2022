package com.hw_27_03.controller;

import com.hw_27_03.dto.CostsBetweenDTO;
import com.hw_27_03.entity.Bill;
import com.hw_27_03.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillService billService;
    Logger logger= LoggerFactory.getLogger(BillController.class);
    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/byId/{id}")
    public Bill getBillById( @PathVariable(value="id") int id){
        return billService.getById(id);
    }

    @GetMapping("/byCost/{cost}")
    public List<Bill> getByCost(@PathVariable(value="cost") double cost){
        return billService.getBillByCost(cost);
    }

}
