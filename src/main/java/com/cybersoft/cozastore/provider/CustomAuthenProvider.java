package com.cybersoft.cozastore.provider;

import com.cybersoft.cozastore.entity.UserEntity;
import com.cybersoft.cozastore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomAuthenProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //Lấy username người dùng truyền vào
        String username = authentication.getName();
        //Lấy password người dùng truyền vào
        String password = authentication.getCredentials().toString();
        UserEntity user = userRepository.findByEmail(username);
        if (user!=null && passwordEncoder.matches(password,user.getPassword())){
            //Đăng nhập thành công
            return new UsernamePasswordAuthenticationToken(username,user.getPassword(),new ArrayList<>());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        //khai báo loại chứng thực sử dụng để so sánh
        return authentication.equals(UsernamePasswordAuthenticationToken.class);

    }
}
