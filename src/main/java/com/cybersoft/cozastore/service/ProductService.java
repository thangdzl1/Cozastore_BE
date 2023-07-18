package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import com.cybersoft.cozastore.repository.ProductRepository;
import com.cybersoft.cozastore.service.Imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (ProductEntity data: list) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(data.getPrice());
            productResponse.setName(data.getName());
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }
}
