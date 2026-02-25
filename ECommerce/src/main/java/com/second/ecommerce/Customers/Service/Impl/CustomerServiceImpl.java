package com.second.ecommerce.Customers.Service.Impl;


import com.second.ecommerce.Customers.Mappers.CustomerMapper;
import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;
import com.second.ecommerce.Customers.Model.Entities.Customer;
import com.second.ecommerce.Customers.Repo.CustomerRepo;
import com.second.ecommerce.Customers.Service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper){
        this.customerRepo=customerRepo;
        this.customerMapper=customerMapper;
    }


    @Override
    public ViewCustomerDTO createCustomer(CreateCustomerDTO createCustomerDTO){
        Customer customerToSave= customerMapper.toModel(createCustomerDTO);
        return customerMapper.toDTO(customerRepo.save(customerToSave));
    }
}
