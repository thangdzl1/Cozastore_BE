package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.entity.OrderEntity;
import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.entity.UserEntity;
import com.cybersoft.cozastore.entity.ids.OrderDetailIds;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderDetailRequest;
import com.cybersoft.cozastore.payload.request.ProductPropertiesRequest;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.payload.response.OrderDetailResponse;
import com.cybersoft.cozastore.repository.*;
import com.cybersoft.cozastore.service.Imp.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements OrderDetailServiceImp {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDetailResponse> findByUser(int id) {
        List<OrderDetailEntity> list = orderDetailRepository.findByUser(id);
        List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
        try {
            for (OrderDetailEntity data :
                    list) {
                OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
                orderDetailResponse.setProductId(data.getProduct().getId());
                orderDetailResponse.setOrderId(data.getOrder().getId());
                orderDetailResponse.setQuantity(data.getQuantity());
                orderDetailResponse.setPrice(data.getPrice());

                orderDetailResponses.add(orderDetailResponse);
            }
        } catch (Exception e) {
            throw new CustomException("Error findByUser in OrderDetailService");
        }
        return orderDetailResponses;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailRequest request) {
        boolean isSuccess = false;
        try {
            OrderDetailEntity entity = new OrderDetailEntity();
            OrderDetailIds ids = new OrderDetailIds();
            ids.setOrderId(request.getOrderId());
            ids.setProductId(request.getProductId());
            entity.setIds(ids);
            entity.setPrice(request.getPrice());
            entity.setQuantity(request.getQuantity());
            orderDetailRepository.save(entity);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Error saveOrderDetail in OrderDetailService " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<OrderDetailResponse> findByUserAndProduct(int userId, int productId) {
        return null;
    }

    @Override
    public boolean addOrderDetail(ProductPropertiesRequest request) {
        boolean isSuccess = false;
        try {
            //find product theo colorId, sizeId và name
            ProductEntity productEntity = productRepository.findByColorIdAndSizeIdAndName(request.getColorId()
                    , request.getSizeId()
                    , request.getProductName());

            //nếu orderDetail chưa có thì tạo orderDetail mới
            OrderDetailEntity orderDetailEntity = orderDetailRepository.findByProductIdAndUserId(productEntity.getId(), request.getUserId());

            if (orderDetailEntity == null) {

                OrderEntity orderEntity = orderRepository.findByUserId(request.getUserId());
                OrderDetailIds orderDetailIds = new OrderDetailIds();
                orderDetailEntity = new OrderDetailEntity();
                int productPrice = productEntity.getPrice();

                orderDetailIds.setOrderId(orderEntity.getId());
                orderDetailIds.setProductId(productEntity.getId());

                // set properties for orderDetailEntity
                orderDetailEntity.setIds(orderDetailIds);
                orderDetailEntity.setQuantity(request.getQuantity());
                orderDetailEntity.setPrice(request.getQuantity()*productPrice);

                productEntity.setQuantity(productEntity.getQuantity() - request.getQuantity());
                productRepository.save(productEntity);
                orderDetailRepository.save(orderDetailEntity);

            } else {
                //Nếu có rồi thì cộng thêm vào quantity và tính lại price
                orderDetailEntity.setQuantity(orderDetailEntity.getQuantity() + request.getQuantity());
                orderDetailEntity.setPrice(orderDetailEntity.getQuantity()* productEntity.getPrice());
                productEntity.setQuantity(productEntity.getQuantity() - request.getQuantity());

                productRepository.save(productEntity);
                orderDetailRepository.save(orderDetailEntity);
            }
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Error addOrderDetail in OrderDetailService " + e.getMessage());
        }
        return isSuccess;
    }
}
