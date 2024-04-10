package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.controller.ProductController;
import com.cybersoft.cozastore.entity.UserEntity;
import com.cybersoft.cozastore.entity.UserReviewEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.SignupRequest;
import com.cybersoft.cozastore.payload.request.UserReviewRequest;
import com.cybersoft.cozastore.payload.response.UserReviewResponse;
import com.cybersoft.cozastore.repository.ProductRepository;
import com.cybersoft.cozastore.repository.UserRepository;
import com.cybersoft.cozastore.repository.UserReviewRepository;
import com.cybersoft.cozastore.service.Imp.UserReviewServiceImp;
import com.cybersoft.cozastore.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserReviewService implements UserReviewServiceImp {
    @Autowired
    private UserReviewRepository userReviewRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DateHelper  dateHelper;

    @Override
    public List<UserReviewResponse> findUserReviewByProductName(String name) {
        try {
            List<UserReviewResponse> responses = new ArrayList<>();
            List<UserReviewEntity> list = userReviewRepository.findByProductName(name);
            for (UserReviewEntity request : list) {
                UserReviewResponse userReview = new UserReviewResponse();
                userReview.setId(request.getId());
                userReview.setProductId(request.getProduct().getId());
                userReview.setEmail(request.getEmail());
                userReview.setName(request.getName());
                userReview.setRating(request.getRating());
                userReview.setCreatedDate(request.getCreatedDate().toString());
                userReview.setReview(request.getReview());
                responses.add(userReview);
            }
            return responses;
        } catch (Exception e) {
            throw new CustomException("Error findUserReviewByProductName in UserReviewService " + e.getMessage());
        }
    }

    @Override
    public boolean AddUserReview(UserReviewRequest request) {
        boolean isSuccess = false;
        try {
            UserReviewEntity userReview = new UserReviewEntity();
            userReview.setProduct(productRepository.findById(request.getProductId()));
            userReview.setEmail(request.getEmail());
            userReview.setName(request.getName());
            userReview.setRating(request.getRating());
            userReview.setReview(request.getReview());
            userReview.setCreatedDate(dateHelper.getInternetTime());
            userReviewRepository.save(userReview);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Error AddUserReview in UserReviewService " + e.getMessage());
        }
        return isSuccess;
    }
}
