package com.second.ecommerce.Customers.Controllers;

import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;
import com.second.ecommerce.Customers.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping
    public ResponseEntity<ViewCustomerDTO> createCustomer(@Valid @RequestBody CreateCustomerDTO createCustomerDTO){

        ViewCustomerDTO viewCustomerDTO= customerService.createCustomer(createCustomerDTO);

        return new ResponseEntity<>(viewCustomerDTO, HttpStatus.CREATED);
    }

}
