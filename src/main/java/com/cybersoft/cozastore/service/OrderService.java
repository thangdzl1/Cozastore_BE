package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.CountryEntity;
import com.cybersoft.cozastore.entity.OrderEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderRequest;
import com.cybersoft.cozastore.payload.response.OrderResponse;
import com.cybersoft.cozastore.repository.CountryRepository;
import com.cybersoft.cozastore.repository.OrderRepository;
import com.cybersoft.cozastore.repository.UserRepository;
import com.cybersoft.cozastore.service.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderResponse findOrderByUser(int id) {
        OrderResponse orderResponse = new OrderResponse();
        try {

            OrderEntity entity = orderRepository.findByUserId(id);
            orderResponse.setCountryId(entity.getCountry().getId());
            orderResponse.setId(entity.getId());
            orderResponse.setPrice(entity.getPrice());
            orderResponse.setDate(entity.getDate());
            orderResponse.setUserId(id);
            orderResponse.setFullAdress(entity.getFull_address());
            orderResponse.setPostalCode(entity.getPostal_code());

        }catch (Exception e){
            throw new CustomException("Error findOrderByUser in OrderService" + e.getMessage());
        }
        return orderResponse;
    }

    @Override
    public boolean updateOrder(OrderRequest orderRequest) {
        boolean isSuccess = false;
        try {
            OrderEntity entity = orderRepository.findByUserId(orderRequest.getUserId());

            // Check if the OrderEntity exists
            if (entity!=null){
                entity.setPrice(orderRequest.getPrice());
                entity.setDate(orderRequest.getDate());
                entity.setFull_address(orderRequest.getFullAdress());
                entity.setPostal_code(orderRequest.getPostalCode());
                entity.setCountry(countryRepository.findById(orderRequest.getCountryId()));
                entity.setUser(userRepository.findById(orderRequest.getUserId()));

            }else {
                // If the OrderEntity does not exist, create a new one
                entity = new OrderEntity();
                entity.setPrice(orderRequest.getPrice());
                entity.setDate(orderRequest.getDate());
                entity.setFull_address(orderRequest.getFullAdress());
                entity.setPostal_code(orderRequest.getPostalCode());
                entity.setCountry(countryRepository.findById(orderRequest.getCountryId()));
                entity.setUser(userRepository.findById(orderRequest.getUserId()));

            }


            orderRepository.save(entity);
            isSuccess = true;
        }catch (Exception e){
            throw new CustomException("Error saveOrder in OrderService: " + e.getMessage());
        }
        return isSuccess;
    }
}
