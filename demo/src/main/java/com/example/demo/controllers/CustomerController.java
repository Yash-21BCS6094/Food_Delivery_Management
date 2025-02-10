package com.example.demo.controllers;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    // creating customer with address
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerServices.createCustomer(customerDTO));
    }

    // updating customer's information
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable UUID customerId,
                                                      @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerServices.updateCustomer(customerId, customerDTO));
    }

    // Get the customer by his Id
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerServices.getCustomerById(customerId));
    }

    // Delete the customer using id
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
        customerServices.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    // Get the customer by his email
    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerServices.getCustomerByEmail(email));
    }

    // Not getting this
    @GetMapping("/search")
    public ResponseEntity<List<CustomerDTO>> searchCustomers(@RequestParam String name) {
        return ResponseEntity.ok(customerServices.searchCustomersByName(name));
    }

    // To get the customer by page and size
    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> getAllCustomers(@RequestParam("page") int page,
                                                             @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.of(Optional.ofNullable(customerServices.getAllCustomer(pageable)));
    }

}
