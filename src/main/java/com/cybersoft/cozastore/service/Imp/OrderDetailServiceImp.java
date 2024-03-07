package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.request.OrderDetailDeleteRequest;
import com.cybersoft.cozastore.payload.request.OrderDetailUpdateRequest;
import com.cybersoft.cozastore.payload.request.ProductPropertiesRequest;
import com.cybersoft.cozastore.payload.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailServiceImp {
    List<OrderDetailResponse> findByUser(int id);
    boolean saveOrderDetail(OrderDetailUpdateRequest request);
    List<OrderDetailResponse> findByUserAndProduct(int userId, int productId);
    boolean addOrderDetail(ProductPropertiesRequest request);
    boolean deleteOrderDetail(OrderDetailDeleteRequest request);
}
