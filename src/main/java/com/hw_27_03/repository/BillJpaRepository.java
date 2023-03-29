package com.hw_27_03.repository;

import com.hw_27_03.entity.Bill;
import com.hw_27_03.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;

import java.util.List;
@Repository
public interface BillJpaRepository extends JpaRepository<Bill,Integer> {
    Bill findById(int id);
    List<Bill> findAll();
    Bill save(Bill bill);
    @Query(value = "SELECT * FROM Bills  where cost=:cost",nativeQuery = true)
    List<Bill> findByCost(double cost);

}
