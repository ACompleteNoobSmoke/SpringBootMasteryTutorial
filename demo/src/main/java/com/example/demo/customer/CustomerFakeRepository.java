package com.example.demo.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Osaretin Omofonmwan", "Piccolo", "Oso@gmail.com"),
                new Customer(2L, "Victoria Marshall", "Korean Drama", "vm@gmail.com"),
                new Customer(3L, "Ade Uwensuyi", "DGrayMan", "619@gmail.com"),
                new Customer(4L, "Boye Uwensuyi", "One Piece", "aUwensuyi@gmail.com"),
                new Customer(5L, "Anderson Silva", "Spiderman", "185Champ@gmail.com"),
                new Customer(6L, "Jose Aldo", "Rio", "KingOfRio@gmail.com")
        );
    }

}
