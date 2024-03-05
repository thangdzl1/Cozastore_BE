package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.OrderRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    @PostMapping("/update")
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
}
