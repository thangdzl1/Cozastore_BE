package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "attributes")
public class AttributesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "attribute")
    private Set<AttributeOptionEntity> attributeOptions;

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

    public Set<AttributeOptionEntity> getAttributeOptions() {
        return attributeOptions;
    }

    public void setAttributeOptions(Set<AttributeOptionEntity> attributeOptions) {
        this.attributeOptions = attributeOptions;
    }
}
