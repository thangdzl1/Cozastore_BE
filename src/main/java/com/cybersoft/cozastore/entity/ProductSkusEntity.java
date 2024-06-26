package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "product_skus")
public class ProductSkusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private long price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @OneToMany(mappedBy = "productSkus")
    private Set<ImageEntity> images;

    @OneToMany
    private Set<AttributesOptionSkusEntity> productAttributes;

    @OneToMany(mappedBy = "productSkus")
    private Set<com.cybersoft.cozastore.entity.UCartItemEntity> uCartItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "productSkus")
    private Set<OrderDetailEntity> orderDetails;

    public Set<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set<com.cybersoft.cozastore.entity.UCartItemEntity> getUCartItems() {
        return uCartItems;
    }

    public void setUCartItems(Set<com.cybersoft.cozastore.entity.UCartItemEntity> uCartItems) {
        this.uCartItems = uCartItems;
    }

    public Set<AttributesOptionSkusEntity> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(Set<AttributesOptionSkusEntity> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Set<ImageEntity> getImages() {
        return images;
    }

    public void setImages(Set<ImageEntity> images) {
        this.images = images;
    }
}
