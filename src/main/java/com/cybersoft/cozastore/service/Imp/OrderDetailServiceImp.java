package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.payload.request.OrderDetailRequest;
import com.cybersoft.cozastore.payload.request.ProductPropertiesRequest;
import com.cybersoft.cozastore.payload.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailServiceImp {
    List<OrderDetailResponse> findByUser(int id);
    boolean saveOrderDetail(OrderDetailRequest request);
    List<OrderDetailResponse> findByUserAndProduct(int userId, int productId);
    boolean addOrderDetail(ProductPropertiesRequest request);
}
