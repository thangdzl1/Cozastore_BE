package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.UserReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReviewEntity, Integer>{
    List<UserReviewEntity> findByProductName(String name);
}
