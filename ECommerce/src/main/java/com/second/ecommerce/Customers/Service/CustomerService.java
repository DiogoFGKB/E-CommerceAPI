package com.second.ecommerce.Customers.Service;

import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    ViewCustomerDTO createCustomer(CreateCustomerDTO createCustomerDTO);

    List<ViewCustomerDTO> getAllCustomers();

    ViewCustomerDTO getCustomerFromId(UUID id);

    ViewCustomerDTO updateCustomerFromId(CreateCustomerDTO createCustomerDTO, UUID id);

    void deleteCustomerFromId(UUID id);
}
