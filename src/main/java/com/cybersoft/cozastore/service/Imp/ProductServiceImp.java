package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int id);
}
