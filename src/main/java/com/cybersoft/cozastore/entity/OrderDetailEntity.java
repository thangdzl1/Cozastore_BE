package com.cybersoft.cozastore.entity;

import com.cybersoft.cozastore.entity.ids.OrderDetailIds;

import javax.persistence.*;

@Entity(name = "order_detail")
public class OrderDetailEntity {

    @EmbeddedId
    OrderDetailIds ids;

    @Column(name = "price")
    private double price = 0;

    @Column(name = "quantity")
    private int quantity = 0;

    @ManyToOne
    @JoinColumn(name = "product_skus_id", insertable = false,updatable = false)
    private ProductSkusEntity productSkus;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false,updatable = false)
    private OrderEntity order;

    public ProductSkusEntity getProduct_skus() {
        return productSkus;
    }

    public void setProduct_skus(ProductSkusEntity product_skus) {
        this.productSkus = product_skus;
    }

    public OrderDetailIds getIds() {
        return ids;
    }

    public void setIds(OrderDetailIds ids) {
        this.ids = ids;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
