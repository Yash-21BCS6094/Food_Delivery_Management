package com.example.demo.controllers;

import com.example.demo.dto.AddressDTO;
import com.example.demo.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressServices addressServices;

    // creating address
    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressServices.createAddress(addressDTO));
    }

    // updating address
    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable UUID addressId,
                                                    @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressServices.updateAddress(addressId, addressDTO));
    }

    // Getting an address
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable UUID addressId) {
        return ResponseEntity.ok(addressServices.getAddressById(addressId));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID addressId) {
        addressServices.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }

}

