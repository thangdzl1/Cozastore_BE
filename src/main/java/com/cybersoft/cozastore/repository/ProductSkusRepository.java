package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.ProductSkusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductSkusRepository extends JpaRepository<ProductSkusEntity, Integer> {
    // Find product by id with min price
    @Query( "select pk " +
            "from product_skus pk " +
            "join pk.product p " +
            "where p.id = ?1 " +
            "order by pk.price")
    ProductSkusEntity findByProductIdWithMinPrice(int id);
}
