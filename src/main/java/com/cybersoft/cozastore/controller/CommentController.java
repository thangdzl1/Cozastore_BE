package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.CommentRequest;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.repository.CommentRepository;
import com.cybersoft.cozastore.service.Imp.CommentServiceImp;
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
@RequestMapping("comment")

public class CommentController {
    @Autowired
    private CommentServiceImp commentServiceImp;
    @PostMapping("")
    public ResponseEntity<?> addComment(@Valid CommentRequest request, BindingResult result) {

        List<FieldError> list = result.getFieldErrors();

        for (FieldError data: list) {
            throw new CustomException(data.getDefaultMessage());
        }

        boolean isSuccess = commentServiceImp.addComment(request);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
