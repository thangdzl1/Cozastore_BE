package com.cybersoft.cozastore.exception;

import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomException {

//  Nơi đăng ký các Exception sẽ kích hoạt code bên trong hàm
    @ExceptionHandler(CustomFileNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(Exception e){

        BaseResponse response = new BaseResponse();
        response.setStatusCode(500);
        response.setData(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(Exception e){
        BaseResponse response = new BaseResponse();
        response.setStatusCode(500);
        response.setData(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
