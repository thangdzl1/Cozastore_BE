package com.cybersoft.cozastore.entity;


import com.cybersoft.cozastore.entity.ids.ProductImageIds;

import javax.persistence.*;

@Entity(name = "product_image")
public class ProductImageEntity {
    @EmbeddedId
    ProductImageIds ids;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "image_id", insertable = false, updatable = false)
    private ImageEntity image;

    public ProductImageIds getIds() {
        return ids;
    }

    public void setIds(ProductImageIds ids) {
        this.ids = ids;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }
}
