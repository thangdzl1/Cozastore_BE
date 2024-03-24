package com.cybersoft.cozastore.entity.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductImageIds implements Serializable {
    @Column(name = "product_id")
    private int productId;
    @Column(name = "image_id")
    private int imageId;

    public ProductImageIds() {
    }

    public ProductImageIds(int productId, int imageId) {
        this.productId = productId;
        this.imageId = imageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
