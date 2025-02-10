package com.example.demo.dto;

import com.example.demo.entity.Order;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public class ProductDTO {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private Double price;
    private List<OrderDTO> orders;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

}
