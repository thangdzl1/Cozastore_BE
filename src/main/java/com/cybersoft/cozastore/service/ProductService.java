package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ImageEntity;
import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import com.cybersoft.cozastore.repository.ImageRepository;
import com.cybersoft.cozastore.repository.ProductRepository;
import com.cybersoft.cozastore.service.Imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        try {
            List<ProductEntity> list = productRepository.findByCategoryId(id);
            for (ProductEntity data : list) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(data.getId());
                productResponse.setPrice(data.getPrice());
                productResponse.setName(data.getName());
                productResponse.setDescription(data.getDescription());
                productResponse.setCategory(data.getCategory().getName());
                productResponse.setQuantity(data.getQuantity());

                // Get image source list and pass to productResponse
                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
                List<String> imageSource = new ArrayList<>();
                for (ImageEntity imageEntity : imageList) {
                    imageSource.add(imageEntity.getSource());
                }

                productResponseList.add(productResponse);
            }
        } catch (Exception e) {
            throw new CustomException("Error getProductByCategory in ProductService" + e.getMessage());
        }

        return productResponseList;
    }

    @Override
    public List<ProductResponse> getProductByUser(int id) {
        List<ProductResponse> productResponseList = new ArrayList<>();

        try {
            List<ProductEntity> list = productRepository.findByUser(id);
            for (ProductEntity data : list) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(data.getId());
                productResponse.setPrice(data.getPrice());
                productResponse.setName(data.getName());
                productResponse.setDescription(data.getDescription());
                productResponse.setCategory(data.getCategory().getName());
                productResponse.setQuantity(data.getQuantity());

                // Get image source list and pass to productResponse
                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
                List<String> imageSource = new ArrayList<>();
                for (ImageEntity imageEntity : imageList) {
                    imageSource.add(imageEntity.getSource());
                }
                productResponseList.add(productResponse);
            }
        } catch (Exception e) {
            throw new CustomException("Error getProductByUser in ProductService" + e.getMessage());
        }

        return productResponseList;
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductResponse productResponse = new ProductResponse();

        try {
            ProductEntity data = productRepository.findById(id);
            productResponse.setId(data.getId());
            productResponse.setPrice(data.getPrice());
            productResponse.setName(data.getName());
            productResponse.setDescription(data.getDescription());
            productResponse.setCategory(data.getCategory().getName());
            productResponse.setQuantity(data.getQuantity());

            // Get image source list and pass to productResponse
            List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
            List<String> imageSource = new ArrayList<>();
            for (ImageEntity imageEntity : imageList) {
                imageSource.add(imageEntity.getSource());
            }

            productResponse.setImage(imageSource);

        } catch (Exception e) {
            throw new CustomException("Error getProductById in ProductService" + e.getMessage());
        }
        return productResponse;
    }

    @Override
    public List<ProductResponse> findAllDistinctProduct(PageRequest pageRequest) {

        List<ProductResponse> productResponseList = new ArrayList<>();
        try {
            Page<ProductEntity> pageList = productRepository.getAllProductGroupByName(pageRequest);
            List<ProductEntity> list = pageList.getContent();//convert page to list
            for (ProductEntity data : list) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(data.getId());
                productResponse.setPrice(data.getPrice());
                productResponse.setName(data.getName());
                productResponse.setDescription(data.getDescription());
                productResponse.setCategory(data.getCategory().getName());
                productResponse.setQuantity(data.getQuantity());

                // Get image source list and pass to productResponse
                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
                List<String> imageSource = new ArrayList<>();
                for (ImageEntity imageEntity : imageList) {
                    imageSource.add(imageEntity.getSource());
                }
                productResponseList.add(productResponse);
            }
        } catch (Exception e) {
            throw new CustomException("Error findAll in ProductService " + e.getMessage());
        }
        return productResponseList;
    }

    @Override
    public List<ProductResponse> getProductByCategoryName(String name) {
        List <ProductResponse> responses = new ArrayList<>();
        try {
            List <ProductEntity> entityList = productRepository.findByCategoryName(name);

            for (ProductEntity data : entityList) {
                ProductResponse productResponse1 = new ProductResponse();
                productResponse1.setId(data.getId());
                productResponse1.setPrice(data.getPrice());
                productResponse1.setName(data.getName());
                productResponse1.setDescription(data.getDescription());
                productResponse1.setCategory(data.getCategory().getName());
                productResponse1.setQuantity(data.getQuantity());

                // Get image source list and pass to productResponse
                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
                List<String> imageSource = new ArrayList<>();
                for (ImageEntity imageEntity : imageList) {
                    imageSource.add(imageEntity.getSource());
                }

                productResponse1.setImage(imageSource);
                responses.add(productResponse1);
            }


        } catch (Exception e) {
            throw new CustomException("Error getProductById in ProductService" + e.getMessage());
        }
        return responses;
    }
}
