package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ImageEntity;
import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.entity.OrderEntity;
import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.entity.ids.OrderDetailIds;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderDetailDeleteRequest;
import com.cybersoft.cozastore.payload.request.OrderDetailUpdateRequest;
import com.cybersoft.cozastore.payload.request.OrderDetailAddRequest;
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
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ImageRepository imageRepository;
//    @Override
//    public List<OrderDetailResponse> findByUser(int id) {
//        List<OrderDetailEntity> list = orderDetailRepository.findByUser(id);
//        List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
//        try {
//            for (OrderDetailEntity data :
//                    list) {
//                OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
//                orderDetailResponse.setProductId(data.getProduct().getId());
//                orderDetailResponse.setOrderId(data.getOrder().getId());
//                orderDetailResponse.setQuantity(data.getQuantity());
//                orderDetailResponse.setPrice(data.getPrice());
//                orderDetailResponse.setProductName(data.getProduct().getName());
//
//                List<ImageEntity> imageEntities = imageRepository.findByProductId(data.getProduct().getId());
//                List<String> imageUrls = new ArrayList<>();
//                for (ImageEntity imageEntity :
//                        imageEntities) {
//                    imageUrls.add(imageEntity.getSource());
//                }
//                orderDetailResponse.setProductImage(imageUrls);
//                orderDetailResponses.add(orderDetailResponse);
//            }
//        } catch (Exception e) {
//            throw new CustomException("Error findByUser in OrderDetailService: " + e.getMessage());
//        }
//        return orderDetailResponses;
//    }

//    @Override
//    public boolean saveOrderDetail(OrderDetailUpdateRequest request) {
//        boolean isSuccess = false;
//        try {
//            OrderDetailEntity entity = new OrderDetailEntity();
//            OrderDetailIds ids = new OrderDetailIds();
//            ids.setOrderId(request.getOrderId());
//            ids.setProductId(request.getProductId());
//            entity.setIds(ids);
//            entity.setPrice(request.getPrice());
//            entity.setQuantity(request.getQuantity());
//            orderDetailRepository.save(entity);
//            isSuccess = true;
//        } catch (Exception e) {
//            throw new CustomException("Error saveOrderDetail in OrderDetailService " + e.getMessage());
//        }
//        return isSuccess;
//    }

//    @Override
//    public List<OrderDetailResponse> findByUserAndProduct(int userId, int productId) {
//        return null;
//    }

//    @Override
//    public boolean addOrderDetail(OrderDetailAddRequest request) {
//        boolean isSuccess = false;
//        try {
//            //find product theo colorId, sizeId và name
//            ProductEntity productEntity = productRepository.findByColorIdAndSizeIdAndName(request.getColorId()
//                    , request.getSizeId()
//                    , request.getProductName());
//
//            //nếu orderDetail chưa có thì tạo orderDetail mới
//            OrderDetailEntity orderDetailEntity = orderDetailRepository.findByProductIdAndUserId(productEntity.getId(), request.getUserId());
//
//            if (orderDetailEntity == null) {
//
//                OrderEntity orderEntity = orderRepository.findByUserId(request.getUserId());
//                OrderDetailIds orderDetailIds = new OrderDetailIds();
//                orderDetailEntity = new OrderDetailEntity();
//                int productPrice = productEntity.getPrice();
//
//                orderDetailIds.setOrderId(orderEntity.getId());
//                orderDetailIds.setProductId(productEntity.getId());
//
//                // set properties for orderDetailEntity and save
//                orderDetailEntity.setIds(orderDetailIds);
//                orderDetailEntity.setQuantity(request.getQuantity());
//                orderDetailEntity.setPrice(request.getQuantity()*productPrice);
//
//                productEntity.setQuantity(productEntity.getQuantity() - request.getQuantity());
//                productRepository.save(productEntity);
//                orderDetailRepository.save(orderDetailEntity);
//
//            } else {
//                //Nếu có rồi thì cộng thêm vào oderDetail's quantity và tính lại price
//                orderDetailEntity.setQuantity(orderDetailEntity.getQuantity() + request.getQuantity());
//                orderDetailEntity.setPrice(orderDetailEntity.getQuantity()* productEntity.getPrice());
//                productEntity.setQuantity(productEntity.getQuantity() - request.getQuantity());
//
//                productRepository.save(productEntity);
//                orderDetailRepository.save(orderDetailEntity);
//            }
//            isSuccess = true;
//        } catch (Exception e) {
//            throw new CustomException("Error addOrderDetail in OrderDetailService " + e.getMessage());
//        }
//        return isSuccess;
//    }

//    @Override
//    public boolean deleteOrderDetail(OrderDetailDeleteRequest request) {
//        boolean isSuccess = false;
//        try {
//            OrderDetailIds ids = new OrderDetailIds();
//
//            ids.setOrderId(request.getOrderId());
//            ids.setProductId(request.getProductId());
//            OrderDetailEntity orderDetailEntity = orderDetailRepository.findById(ids)
//                                                        .orElseThrow(() -> new CustomException("OrderDetail not found"));
//
//            orderDetailRepository.delete(orderDetailEntity);
//            isSuccess = true;
//        } catch (Exception e) {
//            throw new CustomException("Error deleteOrderDetail in OrderDetailService " + e.getMessage());
//        }
//        return isSuccess;
//    }
}
