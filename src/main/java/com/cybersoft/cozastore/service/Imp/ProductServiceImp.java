package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int id);
    List<ProductResponse> getProductByUser(int id);
    ProductResponse getProductById(int id);
    List<ProductResponse> findAllDistinctProduct(PageRequest pageRequest);
    List<ProductResponse> getProductByCategoryName(String name);
}
