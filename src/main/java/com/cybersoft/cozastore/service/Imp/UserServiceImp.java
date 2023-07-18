package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.request.SignupRequest;
import org.springframework.stereotype.Service;


public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
