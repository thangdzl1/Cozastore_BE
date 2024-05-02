package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Integer>, PagingAndSortingRepository<ProductEntity, Integer>{
    List<ProductEntity>findByCategoryId(int id);

    @Query("select p from product p " +
            "join p.orderDetails od " +
            "join od.order o " +
            "join o.user u where u.id = ?1")
    List<ProductEntity>findByUser(int id);

    ProductEntity findById(int id);

//    ProductEntity findByColorIdAndSizeIdAndName(int colorId, int sizeId, String name);

    @Query("select p " +
            "from product p " +
            "where p.id " +
            "in (" +
            "select min (p.id) " +
            "from product p " +
            "group by p.name)")
    Page<ProductEntity> getAllProductGroupByName(PageRequest pageRequest);

    List<ProductEntity> findByCategoryName(String name);
}
