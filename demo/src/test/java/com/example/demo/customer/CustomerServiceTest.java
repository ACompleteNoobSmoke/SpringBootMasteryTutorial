package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomer() {
        Customer Einsetein = new Customer(1L, "Albert Einstein","genius", "eingtein@gmail.com");
        customerRepository.save(Einsetein);
        //When
        Customer actual = underTest.getCustomer(1L);

        //Then
        assertEquals(1L, actual.getID());
        assertEquals("Albert Einstein", actual.getName());
        assertEquals("genius", actual.getPassword());
        assertEquals("eingtein@gmail.com", actual.getEmail());
    }

    @Test
    void getCustomers() {
        Customer Einsetein = new Customer(1L, "Albert Einstein","genius", "eingtein@gmail.com");
        Customer Lawler = new Customer(2L, "Robbie Lawler", "Ruthless", "RuthlessMMA@gmail.com");
        customerRepository.saveAll(Arrays.asList(Einsetein, Lawler));

        //When
        List<Customer> customers = underTest.getCustomers();

        //Then
        assertEquals(2, customers.size());
    }
}