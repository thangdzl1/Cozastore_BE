package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.ColorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("color")
public class ColorController {
    @Autowired
    private ColorServiceImp colorServiceImp;

    @GetMapping("")
    public ResponseEntity<?> findAllColorByProductName(String name){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(colorServiceImp.findAllColorByProductName(name));
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
