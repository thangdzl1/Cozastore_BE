package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderDetailRequest;
import com.cybersoft.cozastore.payload.request.OrderRequest;
import com.cybersoft.cozastore.payload.request.ProductPropertiesRequest;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.payload.response.OrderDetailResponse;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import com.cybersoft.cozastore.repository.OrderRepository;
import com.cybersoft.cozastore.service.Imp.OrderDetailServiceImp;
import com.cybersoft.cozastore.service.Imp.OrderServiceImp;
import com.cybersoft.cozastore.service.Imp.ProductServiceImp;
import com.cybersoft.cozastore.service.OrderDetailService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private OrderDetailServiceImp orderDetailServiceImp;

    @Autowired
    private OrderServiceImp orderServiceImp;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    private Gson gson = new Gson();

    @GetMapping("")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id){
        logger.info("Tham so " + id);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(productServiceImp.getProductByCategory(id));

        logger.info(gson.toJson(baseResponse));
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> getProductByUser(@RequestParam int userId){
        List<ProductResponse> listProduct = productServiceImp.getProductByUser(userId);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(listProduct);

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @PostMapping("/order-detail")
    public ResponseEntity<?> getOrderDetailByUser(@RequestParam int userId){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(orderDetailServiceImp.findByUser(userId));

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @PostMapping("/order-detail/update")
    public ResponseEntity<?> updateOrderDetail(@Valid OrderDetailRequest request, BindingResult result) {

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

    @PostMapping("/order/update")
    public ResponseEntity<?> updateOrder(@Valid OrderRequest request, BindingResult result) {

        List<FieldError> list = result.getFieldErrors();

        for (FieldError data: list) {
            throw new CustomException(data.getDefaultMessage());
        }

        boolean isSuccess = orderServiceImp.saveOrder(request);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("order-detail/add")
    public ResponseEntity<?> addProductToOrderDetail(@Valid ProductPropertiesRequest request,  BindingResult result){
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
}
