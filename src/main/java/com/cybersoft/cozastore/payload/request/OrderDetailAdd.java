package com.cybersoft.cozastore.payload.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDetailAdd {
    @NotNull(message = "Please select a size")
    @NotEmpty(message = "Please select a size")
    private int sizeId;
    @NotNull(message = "Please select a color")
    @NotEmpty(message = "Please select a color")
    private int colorId;
    private int quantity;
    private String productName;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
