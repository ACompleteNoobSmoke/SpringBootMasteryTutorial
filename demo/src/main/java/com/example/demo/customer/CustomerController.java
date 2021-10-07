package com.example.demo.customer;

import com.example.demo.exception.APIRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "{customerID}")
    Customer getCustomer(@PathVariable("customerID") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerID}/exception")
    Customer getCustomerException(@PathVariable("customerID") Long id){
        throw new APIRequestException("APIRequestException For Customer ID:" + id);
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void createNewCustomer(@RequestBody @Valid Customer newCustomer){
        System.out.println("POST REQUEST!");
        System.out.println(newCustomer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE REQUEST");
        System.out.println(customer);
    }

    @DeleteMapping(path = "delete/{customerID}")
    void deleteCustomer(@PathVariable("customerID") Long customerID){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID: " + customerID);
    }

}
