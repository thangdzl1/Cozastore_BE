package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.UserReviewServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-review")
public class UserReviewController {
    @Autowired
    private UserReviewServiceImp userReviewServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getUserReviewByProductName(@RequestParam String name){

        BaseResponse response = new BaseResponse();
        response.setData(userReviewServiceImp.findUserReviewByProductName(name));
        response.setStatusCode(200);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
