package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderDetailRequest;
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
        try {
            for (OrderDetailEntity data:
                    list) {
                OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
                orderDetailResponse.setProductId(data.getProduct().getId());
                orderDetailResponse.setOrderId(data.getOrder().getId());
                orderDetailResponse.setQuantity(data.getQuantity());
                orderDetailResponse.setPrice(data.getPrice());

                orderDetailResponses.add(orderDetailResponse);
            }
        }catch (Exception e){
            throw new CustomException("Error findByUser in OrderDetailService");
        }
        return orderDetailResponses;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailRequest request){
        boolean isSuccess = false;
        try {
            OrderDetailEntity entity = new OrderDetailEntity();
            entity.getIds().setOrderId(request.getOrderDetailId());
            entity.getIds().setProductId(request.getProductId());
            entity.setPrice(request.getPrice());
            entity.setQuantity(request.getQuantity());
            orderDetailRepository.save(entity);
            isSuccess = true;
        }catch (Exception e){
            throw new CustomException("Error saveOrderDetail" + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<OrderDetailResponse> findByUserAndProduct(int userId, int productId){
        return null;
    }
}
