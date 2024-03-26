package com.cybersoft.cozastore.payload.request;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderDetailAddRequest {
    @NotNull(message = "Please select a size")
    @Min(message = "Please select a size", value = 1)
    private int sizeId;
    @NotNull(message = "Please select a color")
    @Min(message = "Please select a color", value = 1)
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
