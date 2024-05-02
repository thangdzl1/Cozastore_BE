package com.cybersoft.cozastore.entity.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AttributesOptionSkusIds implements Serializable {
    @Column(name = "attribute_option_id")
    private int attributeOptionId;
    @Column(name = "sku_id")
    private int skuId;

    public AttributesOptionSkusIds() {
    }

    public AttributesOptionSkusIds(int attributeOptionId, int skuId) {
        this.attributeOptionId = attributeOptionId;
        this.skuId = skuId;
    }

    public int getAttributeOptionId() {
        return attributeOptionId;
    }

    public void setAttributeOptionId(int attributeOptionId) {
        this.attributeOptionId = attributeOptionId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }
}
