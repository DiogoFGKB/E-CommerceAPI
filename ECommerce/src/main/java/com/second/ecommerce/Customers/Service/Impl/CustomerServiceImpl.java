package com.second.ecommerce.Customers.Service.Impl;


import com.second.ecommerce.Customers.Mappers.CustomerMapper;
import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;
import com.second.ecommerce.Customers.Model.Entities.Customer;
import com.second.ecommerce.Customers.Repo.CustomerRepo;
import com.second.ecommerce.Customers.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<ViewCustomerDTO> getAllCustomers(){

        List<Customer> allCustomers=customerRepo.getAllCustomers();
        List<ViewCustomerDTO> allCustomersDTO= new ArrayList<>();

        for (Customer customer : allCustomers ){
            allCustomersDTO.add(customerMapper.toDTO(customer));
        }

        return allCustomersDTO;
    }

    @Override
    public ViewCustomerDTO getCustomerFromId(UUID id){
        return customerMapper.toDTO(customerRepo.getCustomerFromId(id));
    }

    @Override
    public ViewCustomerDTO updateCustomerFromId(CreateCustomerDTO createCustomerDTO, UUID id){

        Customer customerToUpdate = customerRepo.getCustomerFromId(id);

        customerToUpdate.setName(createCustomerDTO.getName());
        customerToUpdate.setEmail(createCustomerDTO.getEmail());
        customerToUpdate.setPhoneNumber(createCustomerDTO.getPhoneNumber());

        return customerMapper.toDTO(customerRepo.save(customerToUpdate));
    }

    @Override
    public void deleteCustomerFromId(UUID id){
        customerRepo.deleteCustomerFromId(id);
    }
}
