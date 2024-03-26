package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderDetailDeleteRequest;
import com.cybersoft.cozastore.payload.request.OrderDetailUpdateRequest;
import com.cybersoft.cozastore.payload.request.OrderDetailAddRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("order-detail")
public class OrderDetailController {
    @Autowired
    private OrderDetailServiceImp orderDetailServiceImp;

    @PostMapping("")
    public ResponseEntity<?> getOrderDetailByUser(@RequestParam int userId){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(orderDetailServiceImp.findByUser(userId));

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrderDetail(@Valid OrderDetailUpdateRequest request, BindingResult result) {

        List<FieldError> list = result.getFieldErrors();

        for (FieldError data: list) {
            throw new CustomException(data.getDefaultMessage());
        }

        boolean isSuccess = orderDetailServiceImp.saveOrderDetail(request);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProductToOrderDetail(@Valid OrderDetailAddRequest request, BindingResult result){
        List<FieldError> list = result.getFieldErrors();

        for (FieldError data: list) {
            throw new CustomException(data.getDefaultMessage());
        }

        boolean isSuccess = orderDetailServiceImp.addOrderDetail(request);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteProductFromOrderDetail(@Valid OrderDetailDeleteRequest request, BindingResult result){
        List<FieldError> list = result.getFieldErrors();

        for (FieldError data: list) {
            throw new CustomException(data.getDefaultMessage());
        }
        boolean isSuccess = orderDetailServiceImp.deleteOrderDetail(request);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
