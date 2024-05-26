package com.cybersoft.cozastore.entity;

import javax.persistence.*;

@Entity
@Table(name = "u_cart_item")
public class UCartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "price")
    private Long price;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_skus_id")
    private ProductSkusEntity productSkus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_cart_id")
    private com.cybersoft.cozastore.entity.UCartEntity uCart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductSkusEntity getProductSkus() {
        return productSkus;
    }

    public void setProductSkus(ProductSkusEntity productSkus) {
        this.productSkus = productSkus;
    }

    public com.cybersoft.cozastore.entity.UCartEntity getUCart() {
        return uCart;
    }

    public void setUCart(com.cybersoft.cozastore.entity.UCartEntity uCart) {
        this.uCart = uCart;
    }

}