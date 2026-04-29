package com.second.ecommerce.Customers.Repo.Impl;

import com.second.ecommerce.Customers.Model.Entities.Customer;
import com.second.ecommerce.Customers.Repo.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepoImpl extends CustomerRepo, JpaRepository<Customer, UUID> {

    @Query("select c from Customer c")
    List<Customer> getAllCustomers();

    @Query("select c from Customer c where c.id= :id")
    Customer getCustomerFromId(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query("delete from Customer c where c.id= :id")
    void deleteCustomerFromId(@Param("id") UUID id);
}
