package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<ColorEntity, Integer>{
    @Query("select c from color c " +
            "join c.products p where p.name = ?1 " +
            "group by c.id")
    List<ColorEntity> findAllByProductName(String name);
}
