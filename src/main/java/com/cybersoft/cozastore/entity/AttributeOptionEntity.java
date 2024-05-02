package com.cybersoft.cozastore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "attribute_options")
public class AttributeOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private AttributesEntity attribute;

    @OneToMany(mappedBy = "attributeOption")
    private Set<AttributesOptionSkusEntity> attributesOptionSkus;

    public Set<AttributesOptionSkusEntity> getAttributesOptionSkus() {
        return attributesOptionSkus;
    }

    public void setAttributesOptionSkus(Set<AttributesOptionSkusEntity> attributesOptionSkus) {
        this.attributesOptionSkus = attributesOptionSkus;
    }

    public AttributesEntity getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributesEntity attribute) {
        this.attribute = attribute;
    }

    public AttributeOptionEntity() {
    }
    public AttributeOptionEntity(int id, String value, int attributeId) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
