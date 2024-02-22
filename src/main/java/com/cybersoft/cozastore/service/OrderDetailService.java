package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.payload.response.OrderDetailResponse;
import com.cybersoft.cozastore.repository.OrderDetailRepository;
import com.cybersoft.cozastore.service.Imp.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements OrderDetailServiceImp {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailResponse> findByUser(int id) {
        List<OrderDetailEntity> list = orderDetailRepository.findByUser(id);
        List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
        for (OrderDetailEntity data:
                list) {
            OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
            orderDetailResponse.setProductId(data.getProduct().getId());
            orderDetailResponse.setOrderId(data.getOrder().getId());
            orderDetailResponse.setQuantity(data.getQuantity());
            orderDetailResponse.setPrice(data.getPrice());

            orderDetailResponses.add(orderDetailResponse);
        }
        return orderDetailResponses;



    }
}
