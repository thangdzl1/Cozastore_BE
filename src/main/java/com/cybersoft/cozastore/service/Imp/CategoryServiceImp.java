package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.CategoryResponse;
import com.cybersoft.cozastore.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryServiceImp {
    List<CategoryResponse> getAllCategory();
}
