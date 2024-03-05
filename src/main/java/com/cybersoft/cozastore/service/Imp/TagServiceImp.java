package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.entity.TagEntity;

import java.util.List;

public interface TagServiceImp {
    List<TagEntity> findAll();
    List<TagEntity> findAllTagByBlogId(int id);
}
