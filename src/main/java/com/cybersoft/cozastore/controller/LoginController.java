package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.filter.JwtFilter;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.provider.CustomAuthenProvider;
import com.cybersoft.cozastore.service.Imp.UserServiceImp;
import com.cybersoft.cozastore.service.UserService;
import com.cybersoft.cozastore.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private CustomAuthenProvider authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserServiceImp userServiceImp;


    /*
    {
        status code:200
        message:""
        data :
    }
    */

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> sigin(
            @RequestParam String email,
            @RequestParam String password
    ) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(token);
        String jwt = jwtHelper.generateToken("Hello login");
        //Nếu chứng thực thành công sẽ chạy code tiếp theo còn nếu thất bại thì sẽ văng lỗi chưa chứng thực
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(jwt);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> sigup( @Valid SignupRequest request ) {
        boolean isSuccess = userServiceImp.addUser(request);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
