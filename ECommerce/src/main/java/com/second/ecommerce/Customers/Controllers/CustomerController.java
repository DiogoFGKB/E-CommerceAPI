package com.second.ecommerce.Customers.Controllers;

import com.second.ecommerce.Customers.Model.DTO.CreateCustomerDTO;
import com.second.ecommerce.Customers.Model.DTO.ViewCustomerDTO;
import com.second.ecommerce.Customers.Service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<ViewCustomerDTO>> listAllCustomers(){

        List<ViewCustomerDTO> allCustomers= customerService.getAllCustomers();

        return new ResponseEntity<>(allCustomers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewCustomerDTO> listCustomerFromId(@PathVariable("id") UUID id){

        ViewCustomerDTO customerToList=customerService.getCustomerFromId(id);

        return new ResponseEntity<>(customerToList,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViewCustomerDTO> updateCustomerFromId(@Valid @RequestBody CreateCustomerDTO createCustomerDTO, @PathVariable("id") UUID id){

        ViewCustomerDTO customerUpdated=customerService.updateCustomerFromId(createCustomerDTO,id);

        return new ResponseEntity<>(customerUpdated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Null> deleteCustomerFromId(@PathVariable("id") UUID id){

        customerService.deleteCustomerFromId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
