package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.request.UserReviewRequest;
import com.cybersoft.cozastore.payload.response.UserReviewResponse;

import java.util.List;

public interface UserReviewServiceImp {
    List<UserReviewResponse> findUserReviewByProductName(String name);
    boolean AddUserReview(UserReviewRequest request);
}
