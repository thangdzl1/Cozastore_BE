package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "archive")
public class ArchiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "archive")
    private Set<BlogEntity> blog;


    public Set<BlogEntity> getBlog() {
        return blog;
    }

    public void setBlog(Set<BlogEntity> blog) {
        this.blog = blog;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
