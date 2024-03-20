package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.UserEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.repository.UserRepository;
import com.cybersoft.cozastore.service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            if(userRepository.findByUsername(request.getUsername()) != null)
                throw new CustomException("Username existed");
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            isSuccess = true;
            userRepository.save(user);
        }catch (Exception e){
            throw new CustomException("Lỗi thêm user "+e.getMessage());
        }
        return isSuccess;
    }
}
