package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.payload.response.BlogResponse;
import com.cybersoft.cozastore.payload.response.UCartItemResponse;
import com.cybersoft.cozastore.service.Imp.UCartItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private UCartItemServiceImp uCartItemServiceImp;
    @PostMapping("item")
    ResponseEntity<?> findAllBlog(@RequestParam int id){
        List<UCartItemResponse> list = uCartItemServiceImp.findAllUCartItemByCartId(id);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
