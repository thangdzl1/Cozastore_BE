package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.AttributeOptionEntity;
import com.cybersoft.cozastore.entity.AttributesOptionSkusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AttributeOptionsRepository extends JpaRepository<AttributeOptionEntity, Integer>{
    @Query("select ao from attributes a " +
            "join a.attributeOptions ao " +
            "join ao.attributesOptionSkus aos " +
            "join aos.sku s " +
            "where a.id = ?1 and s.product.id = ?2")
    List<AttributeOptionEntity> findAllByAttributeIdAndProductId(int attributeId, int productId);

    @Query("select ao from attribute_options ao " +
            "join ao.attributesOptionSkus aos " +
            "join aos.sku s " +
            "where s.id = ?1")
    List<AttributeOptionEntity> findAllByProductSkusId(int id);
}
