package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<CategoryTagEntity> categoryTagEntities;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products;

    public Set<CategoryTagEntity> getCategoryTags() {
        return categoryTagEntities;
    }

    public void setCategoryTags(Set<CategoryTagEntity> categoryTagEntities) {
        this.categoryTagEntities = categoryTagEntities;
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

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}
