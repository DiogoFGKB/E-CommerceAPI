package com.second.ecommerce.Customers.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ViewCustomerDTO {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
}
