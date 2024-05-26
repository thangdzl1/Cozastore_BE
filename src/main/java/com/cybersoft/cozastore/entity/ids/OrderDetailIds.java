package com.cybersoft.cozastore.entity.ids;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailIds implements Serializable {

    @Column(name = "product_skus_id")
    private int productSkusId;

    @Column(name = "order_id")
    private int orderId;

    public OrderDetailIds(){}

    public OrderDetailIds(int productSkusId, int orderId){
        this.productSkusId = productSkusId;
        this.orderId = orderId;
    }

    public int getProductSkusId() {
        return productSkusId;
    }

    public void setProductSkusId(int productSkusId) {
        this.productSkusId = productSkusId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
