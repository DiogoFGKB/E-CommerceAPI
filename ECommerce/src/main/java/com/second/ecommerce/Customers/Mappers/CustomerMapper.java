package com.second.ecommerce.Customers.Mappers;

import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;
import com.second.ecommerce.Customers.Model.Entities.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toModel(CreateCustomerDTO createCustomerDTO){

        Customer customer=new Customer(createCustomerDTO.getName(), createCustomerDTO.getEmail(), createCustomerDTO.getPhoneNumber());

        return customer;
    }

    public ViewCustomerDTO toDTO(Customer customer){

        ViewCustomerDTO viewCustomerDTO=new ViewCustomerDTO(customer.getId().toString(),customer.getName(),customer.getEmail(),customer.getPhoneNumber());

        return viewCustomerDTO;
    }
}
