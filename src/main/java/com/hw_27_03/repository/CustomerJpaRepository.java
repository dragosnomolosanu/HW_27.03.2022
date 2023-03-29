package com.hw_27_03.repository;

import com.hw_27_03.entity.Customer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
    List<Customer> findAll();
    Customer save(Customer customer);
    @Query("SELECT c from Customer c where c.name like %?1")
    List<Customer> findByName(String firstName);

//    @Modifying
//    @Query(value="Insert INTO Customer (customer_adress,customer_id_proof,customer_name,customer_mobile_phone," +
//            "customer_type,subscriptionid) values (adress,idproof,name,mobile,type,subscriptionid")
//    void insertCustomer(@Param("customer_adress") String adress,@Param("customer_id_proof") String id_proof,
//                        @Param("customer_name") String name, @Param("customer_mobile_phone") String phone,@Param("customer_type")
//                        String type, @Param("subscriptionid") int subscriptionid);
    @Modifying
    @Transactional
    @Query("Update Customer set adress=:adress where id=:id")
    Integer updateAdress(int id,String adress);
}
