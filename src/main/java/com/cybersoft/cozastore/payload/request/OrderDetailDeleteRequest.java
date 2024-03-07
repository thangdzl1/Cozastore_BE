package com.cybersoft.cozastore.payload.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDetailDeleteRequest {
    @NotNull(message = "product id must not be null")
    @NotEmpty(message = "product id must not be empty")
    private int productId;

    @NotNull(message = "order id must not be null")
    @NotEmpty(message = "order id must not be empty")
    private int orderId;

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

}
