package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.UserReviewRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.UserReviewServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @PostMapping("/add")
    public ResponseEntity<?> addUserReview(@Valid UserReviewRequest request, BindingResult result){
        List<FieldError> list = result.getFieldErrors();
        for (FieldError data: list){
            throw new CustomException(data.getDefaultMessage());
        }
        BaseResponse response = new BaseResponse();
        response.setData(userReviewServiceImp.AddUserReview(request));
        response.setStatusCode(200);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
