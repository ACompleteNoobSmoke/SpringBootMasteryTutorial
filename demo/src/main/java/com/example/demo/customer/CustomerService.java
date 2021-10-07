package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepo;

    Customer getCustomer(Long id){
        return customerRepo
                .findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFound = new NotFoundException("Customer With ID#:" + id + " Not Found");
                    log.error("Error In Getting Customer {}", id, notFound);
                    return notFound;
                });
    }

    List<Customer> getCustomers(){
        log.info("Get Customers Was Called");
        return customerRepo.findAll();
    }
}
