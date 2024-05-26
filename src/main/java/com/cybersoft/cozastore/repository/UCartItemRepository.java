package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.UCartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UCartItemRepository extends JpaRepository<UCartItemEntity, Integer>{
    @Query("select u from UCartItemEntity u where u.uCart.id = ?1")
    List<UCartItemEntity> findAllByUCartId(int id);
}
