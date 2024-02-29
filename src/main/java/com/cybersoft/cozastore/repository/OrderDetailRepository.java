package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.OrderDetailEntity;
import com.cybersoft.cozastore.entity.ids.OrderDetailIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailIds> {
    @Query("select od from order_detail od " +
            "join od.order o " +
            "join o.user u where u.id = ?1")
    List<OrderDetailEntity> findByUser(int id);

    @Query("select od from product p " +
            "join p.orderDetails od " +
            "join od.order o " +
            "join o.user u where p.id =?1 and u.id = ?2")
    OrderDetailEntity findByProductIdAndUserId(int productId, int userId);
}
