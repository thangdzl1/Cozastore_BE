package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity must be greater than 0")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetailEntity> orderDetails;

    @OneToMany(mappedBy = "product")
    private Set<UserReviewEntity> userReviews;

    @OneToMany(mappedBy = "product")
    private Set<ProductSkusEntity> productSkus;

    public Set<UserReviewEntity> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(Set<UserReviewEntity> userReviews) {
        this.userReviews = userReviews;
    }

    public Set<ProductSkusEntity> getProductSkus() {
        return productSkus;
    }

    public void setProductSkus(Set<ProductSkusEntity> productSkus) {
        this.productSkus = productSkus;
    }

    public Set<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
