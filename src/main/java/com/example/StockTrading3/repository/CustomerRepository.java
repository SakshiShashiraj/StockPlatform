package com.example.StockTrading3.repository;

import com.example.StockTrading3.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    public Optional<Customer> findById(Long id) {
        return customers.stream().filter(customer -> (customer.getId() == id)).findFirst();
    }

    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public List<Customer> findByNameContainingIgnoreCase(String name) {
        return customers.stream()
                .filter(customer -> customer.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
