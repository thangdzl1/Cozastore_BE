package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("size")
public class SizeController {
    @Autowired
    private SizeServiceImp sizeServiceImp;

    @GetMapping("")
    public ResponseEntity<?> findAllSizeByProductName(@RequestParam String productName){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(sizeServiceImp.findAllSizeByProductName(productName));
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
