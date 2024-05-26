package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "u_cart")
public class UCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "uCart")
    private Set<com.cybersoft.cozastore.entity.UCartItemEntity> uCartItems = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<com.cybersoft.cozastore.entity.UCartItemEntity> getUCartItems() {
        return uCartItems;
    }

    public void setUCartItems(Set<com.cybersoft.cozastore.entity.UCartItemEntity> uCartItems) {
        this.uCartItems = uCartItems;
    }

}