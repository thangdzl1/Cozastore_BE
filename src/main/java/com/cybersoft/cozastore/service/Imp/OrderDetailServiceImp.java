package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.payload.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailServiceImp {
    List<OrderDetailResponse> findByUser(int id);
}
