package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.UserEntity;
import com.cybersoft.cozastore.entity.UserReviewEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.payload.response.UserReviewResponse;
import com.cybersoft.cozastore.repository.UserRepository;
import com.cybersoft.cozastore.repository.UserReviewRepository;
import com.cybersoft.cozastore.service.Imp.UserReviewServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserReviewService implements UserReviewServiceImp{
    @Autowired
    private UserReviewRepository userReviewRepository;
    @Override
    public List<UserReviewResponse> findUserReviewByProductName(String name) {
        try {
            List<UserReviewResponse> responses = new ArrayList<>();
            List<UserReviewEntity> list = userReviewRepository.findByProductName(name);
            for (UserReviewEntity data : list) {
                UserReviewResponse userReview = new UserReviewResponse();
                userReview.setId(data.getId());
                userReview.setProductId(data.getProduct().getId());
                userReview.setEmail(data.getEmail());
                userReview.setName(data.getName());
                userReview.setRating(data.getRating());
                userReview.setCreatedDate(data.getCreatedDate().toString());
                userReview.setReview(data.getReview());
                responses.add(userReview);
            }
            return responses;
        }catch (Exception e){
            throw new CustomException("Error addUser in UserServiceImp "+e.getMessage());
        }
    }
}
