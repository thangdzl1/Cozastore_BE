package com.cybersoft.cozastore.payload.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderRequest {

    @NotNull(message = "countryId id must not be null")
    @NotEmpty(message = "countryId id must not be empty")
    private int countryId;

    @NotNull(message = "fullAdress id must not be null")
    @NotEmpty(message = "fullAdress id must not be empty")
    private String fullAdress;

    @NotNull(message = "postalCode id must not be null")
    @NotEmpty(message = "postalCode id must not be empty")
    private String postalCode;

    @NotNull(message = "price id must not be null")
    @NotEmpty(message = "price id must not be empty")
    private int price;

    @NotNull(message = "date id must not be null")
    @NotEmpty(message = "date id must not be empty")
    private Date date;

    @NotNull(message = "id must not be null")
    @NotEmpty(message = "id must not be empty")
    private int id;

    @NotNull(message = "userId must not be null")
    @NotEmpty(message = "userId must not be empty")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getFullAdress() {
        return fullAdress;
    }

    public void setFullAdress(String fullAdress) {
        this.fullAdress = fullAdress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
