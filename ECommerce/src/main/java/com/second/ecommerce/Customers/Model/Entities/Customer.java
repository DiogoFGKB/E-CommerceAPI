package com.second.ecommerce.Customers.Model.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id",nullable = false)
    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    @Column(name = "Name",nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "PhoneNumber",nullable = false, unique = true)
    private String phoneNumber;

    @Getter
    @Setter
    private Instant createdAt;

    public Customer(){

    }

    public Customer(String name, String email, String phoneNumber){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    @PrePersist
    public void createAtValue(){
        this.createdAt=Instant.now();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof Customer)) return false;
        Customer customer=(Customer) obj;
        return Objects.equals(email,customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Email: " + this.email + "\n" +
                "PhoneNumber: " + this.phoneNumber + "\n";
    }
}
