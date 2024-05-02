package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
//    @Query("SELECT i FROM p_image i " +
//            "JOIN i.productImages pi " +
//            "join pi.product p " +
//            "WHERE p.id = ?1")
//    List<ImageEntity> findByProductId(int id);
}
