package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
    List<TagEntity> findAll();

    @Query("select t from tag t " +
            "join t.tagBlogs b " +
            "join b.ids i where i = ?1 ")
    List<TagEntity> findAllByBlogId(int id);
}
