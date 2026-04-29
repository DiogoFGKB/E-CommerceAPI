package com.second.ecommerce.Customers.Repo;

import com.second.ecommerce.Customers.Model.Entities.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepo {

    Customer save(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerFromId(UUID id);

    void deleteCustomerFromId(UUID id);
}
