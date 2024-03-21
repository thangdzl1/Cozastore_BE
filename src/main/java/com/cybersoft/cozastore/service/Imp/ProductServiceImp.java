package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int id);
    List<ProductResponse> getProductByUser(int id);
    ProductResponse getProductById(int id);
    List<ProductResponse> findAllDistinctProduct();
}
