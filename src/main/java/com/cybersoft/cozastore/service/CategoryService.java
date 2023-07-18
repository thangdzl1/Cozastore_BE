package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.CategoryEntity;
import com.cybersoft.cozastore.payload.response.CategoryResponse;
import com.cybersoft.cozastore.repository.CategoryRepository;
import com.cybersoft.cozastore.service.Imp.CategoryServiceImp;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryResponse> categoryResponseList = new ArrayList<>();

        for (CategoryEntity data : list) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(data.getId());
            categoryResponse.setName(data.getName());

            categoryResponseList.add(categoryResponse);
        }

        return categoryResponseList;
    }
}
