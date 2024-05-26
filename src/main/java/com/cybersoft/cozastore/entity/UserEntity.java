package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<BlogEntity> blogs;

    @OneToMany(mappedBy = "user")
    private Set<OrderEntity> orders;

    @OneToMany(mappedBy = "user")
    private Set<com.cybersoft.cozastore.entity.UCartEntity> uCarts = new LinkedHashSet<>();

    public Set<com.cybersoft.cozastore.entity.UCartEntity> getUCarts() {
        return uCarts;
    }

    public void setUCarts(Set<com.cybersoft.cozastore.entity.UCartEntity> uCarts) {
        this.uCarts = uCarts;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<BlogEntity> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<BlogEntity> blogs) {
        this.blogs = blogs;
    }
}
