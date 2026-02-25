package com.second.ecommerce.Customers.Repo.Impl;

import com.second.ecommerce.Customers.Model.Entities.Customer;
import com.second.ecommerce.Customers.Repo.CustomerRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepoImpl extends CustomerRepo, JpaRepository<Customer, UUID> {

}
