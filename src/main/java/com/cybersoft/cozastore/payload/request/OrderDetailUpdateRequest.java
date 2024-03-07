package com.cybersoft.cozastore.payload.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDetailUpdateRequest {

    @NotNull(message = "quantity must not be null")
    @NotEmpty(message = "quantity must not be empty")
    private int quantity;

    @NotNull(message = "product id must not be null")
    @NotEmpty(message = "product id must not be empty")
    private int productId;

    @NotNull(message = "order id must not be null")
    @NotEmpty(message = "order id must not be empty")
    private int orderId;

    @NotNull(message = "price must not be null")
    @NotEmpty(message = "price must not be empty")
    private int price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
