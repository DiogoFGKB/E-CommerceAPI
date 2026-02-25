package com.second.ecommerce.Customers.Model.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import static com.second.ecommerce.Customers.Model.Validation.ValidationMessage.*;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerDTO {

    @NotBlank(message = NAME_BLANK_ERROR)
    @Length(max = 12,message = NAME_EXCCED_CHARACTERS)
    private String name;

    @Email(message = EMAIL_ERROR)
    private String email;

    @Pattern(regexp = "^[0-9]{9}$", message = PHONENUMBER_ERROR)
    private String phoneNumber;


}
