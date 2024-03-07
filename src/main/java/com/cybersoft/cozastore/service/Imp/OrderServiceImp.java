package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.request.OrderRequest;
import com.cybersoft.cozastore.payload.response.OrderResponse;

public interface OrderServiceImp {
    OrderResponse findOrderByUser(int id);
    boolean updateOrder(OrderRequest orderRequest);
}
