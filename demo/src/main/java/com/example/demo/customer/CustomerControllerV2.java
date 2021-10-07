package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping(path = "api/v2/customer")
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomer(){
        //return customerService.getCustomers();
        return Arrays.asList(
                new Customer(1L, "V2", "Juice", "Juicy@gmail.com")
        );
    }

    @PostMapping
    public void createNewCustomer(@RequestBody Customer newCustomer){
        System.out.println("POST REQUEST!");
        System.out.println(newCustomer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE REQUEST");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerID}")
    void deleteCustomer(@PathVariable("customerID") Long customerID){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID: " + customerID);
    }

}
