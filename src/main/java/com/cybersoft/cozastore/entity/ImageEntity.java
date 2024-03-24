package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "p_image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "source")
    private String source;
    @Column(name = "detail")
    private String detail;

    @OneToMany(mappedBy = "image")
    Set<ProductImageEntity> productImages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Set<ProductImageEntity> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImageEntity> productImages) {
        this.productImages = productImages;
    }
}
