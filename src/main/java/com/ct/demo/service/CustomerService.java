package com.ct.demo.service;

import com.ct.demo.model.Customer;
import com.ct.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getByID(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> updateCustomer(Long id, Customer updateCustomer) {
        return customerRepository.findById(id).map(existing -> {
            existing.setFirstName(updateCustomer.getFirstName());
            existing.setLastName(updateCustomer.getLastName());
            existing.setEmail(updateCustomer.getEmail());
            return customerRepository.save(existing);
        });
    }
}
