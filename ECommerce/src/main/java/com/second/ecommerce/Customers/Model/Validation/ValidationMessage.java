package com.second.ecommerce.Customers.Model.Validation;

public class ValidationMessage {

    public static final String NAME_BLANK_ERROR="The Customer name can not be blank";

    public static final String NAME_EXCCED_CHARACTERS="The Customer name should have less than 12 characters";

    public static final String EMAIL_ERROR="The Customer email should be a correct email";

    public static final String PHONENUMBER_ERROR="The PhoneNumber should have exactly 9 numbers";

    public ValidationMessage(){

    }
}
