package com.second.ecommerce.Customers.Service;

import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;

public interface CustomerService {

    ViewCustomerDTO createCustomer(CreateCustomerDTO createCustomerDTO);
}
