package com.cybersoft.cozastore.entity;

import com.cybersoft.cozastore.entity.ids.AttributesOptionSkusIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "attributes_option_skus")
public class AttributesOptionSkusEntity {
    @EmbeddedId
    private AttributesOptionSkusIds ids;

    @ManyToOne
    @JoinColumn(name = "attribute_option_id", insertable = false, updatable = false)
    private AttributeOptionEntity attributeOption;

    @ManyToOne
    @JoinColumn(name = "sku_id", insertable = false, updatable = false)
    private ProductSkusEntity sku;

    public AttributesOptionSkusIds getIds() {
        return ids;
    }

    public void setIds(AttributesOptionSkusIds ids) {
        this.ids = ids;
    }

    public AttributeOptionEntity getAttributeOption() {
        return attributeOption;
    }

    public void setAttributeOption(AttributeOptionEntity attributeOption) {
        this.attributeOption = attributeOption;
    }

    public ProductSkusEntity getSku() {
        return sku;
    }

    public void setSku(ProductSkusEntity sku) {
        this.sku = sku;
    }
}
