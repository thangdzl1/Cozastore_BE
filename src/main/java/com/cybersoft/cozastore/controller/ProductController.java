package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import com.cybersoft.cozastore.service.Imp.OrderDetailServiceImp;
import com.cybersoft.cozastore.service.Imp.OrderServiceImp;
import com.cybersoft.cozastore.service.Imp.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<ProductResponse> listProduct = productServiceImp.findAllDistinctProduct();

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(listProduct);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
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


}
