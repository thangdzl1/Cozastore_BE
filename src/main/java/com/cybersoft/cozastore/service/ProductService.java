package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ImageEntity;
import com.cybersoft.cozastore.entity.ProductEntity;
import com.cybersoft.cozastore.entity.ProductSkusEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.ProductResponse;
import com.cybersoft.cozastore.repository.ImageRepository;
import com.cybersoft.cozastore.repository.ProductRepository;
import com.cybersoft.cozastore.repository.ProductSkusRepository;
import com.cybersoft.cozastore.service.Imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductSkusRepository productSkusRepository;

//    @Override
//    public List<ProductResponse> getProductByCategory(int id) {
//        List<ProductResponse> productResponseList = new ArrayList<>();
//        try {
//            List<ProductEntity> list = productRepository.findByCategoryId(id);
//            for (ProductEntity data : list) {
//                ProductResponse productResponse = new ProductResponse();
//                productResponse.setId(data.getId());
//                productResponse.setPrice(data.getPrice());
//                productResponse.setName(data.getName());
//                productResponse.setDescription(data.getDescription());
//                productResponse.setCategory(data.getCategory().getName());
//                productResponse.setQuantity(data.getQuantity());
//
//                // Get image source list and pass to productResponse
//                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
//                List<String> imageSource = new ArrayList<>();
//                for (ImageEntity imageEntity : imageList) {
//                    imageSource.add(imageEntity.getSource());
//                }
//
//                productResponseList.add(productResponse);
//            }
//        } catch (Exception e) {
//            throw new CustomException("Error getProductByCategory in ProductService" + e.getMessage());
//        }
//
//        return productResponseList;
//    }

    //    @Override
//    public List<ProductResponse> getProductByUser(int id) {
//        List<ProductResponse> productResponseList = new ArrayList<>();
//
//        try {
//            List<ProductEntity> list = productRepository.findByUser(id);
//            for (ProductEntity data : list) {
//                ProductResponse productResponse = new ProductResponse();
//                productResponse.setId(data.getId());
//                productResponse.setPrice(data.getPrice());
//                productResponse.setName(data.getName());
//                productResponse.setDescription(data.getDescription());
//                productResponse.setCategory(data.getCategory().getName());
//                productResponse.setQuantity(data.getQuantity());
//
//                // Get image source list and pass to productResponse
//                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
//                List<String> imageSource = new ArrayList<>();
//                for (ImageEntity imageEntity : imageList) {
//                    imageSource.add(imageEntity.getSource());
//                }
//                productResponseList.add(productResponse);
//            }
//        } catch (Exception e) {
//            throw new CustomException("Error getProductByUser in ProductService" + e.getMessage());
//        }
//
//        return productResponseList;
//    }
//
//    @Override
//    public ProductResponse getProductById(int id) {
//        ProductResponse productResponse = new ProductResponse();
//
//        try {
//            ProductEntity data = productRepository.findById(id);
//            productResponse.setId(data.getId());
//            productResponse.setPrice(data.getPrice());
//            productResponse.setName(data.getName());
//            productResponse.setDescription(data.getDescription());
//            productResponse.setCategory(data.getCategory().getName());
//            productResponse.setQuantity(data.getQuantity());
//
//            // Get image source list and pass to productResponse
//            List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
//            List<String> imageSource = new ArrayList<>();
//            for (ImageEntity imageEntity : imageList) {
//                imageSource.add(imageEntity.getSource());
//            }
//
//            productResponse.setImage(imageSource);
//
//        } catch (Exception e) {
//            throw new CustomException("Error getProductById in ProductService" + e.getMessage());
//        }
//        return productResponse;
//    }
//

    /**
     * This section of the code creates a ProductResponse object for each ProductEntity in the list.
     *
     * A new ProductResponse object is created to hold the details of a product that will be sent as a response.
     *
     * The ProductSkusEntity with the minimum price for the current product is retrieved from the database using the
     * findByProductIdWithMinPrice method of the productSkusRepository.
     *
     * The details of the product and the SKU with the minimum price are set in the ProductResponse object. These details
     * include the product's id, name, description, full description, category name, price, and quantity.
     */
    @Override
    public List<ProductResponse> findAllProduct(Pageable pageable) {

        List<ProductResponse> productResponseList = new ArrayList<>();
        try {
            Page<ProductEntity> pageList = productRepository.getAllProduct(pageable);
            List<ProductEntity> list = pageList.getContent();//convert page to list

            for (ProductEntity data : list) {

                ProductResponse productResponse = new ProductResponse();

                productResponse.setId(data.getId());
                productResponse.setName(data.getName());
                productResponse.setDescription(data.getDescription());
                productResponse.setFullDescription(data.getFullDescription());
                productResponse.setCategory(data.getCategory().getName());

                ProductSkusEntity productSkusEntity = productSkusRepository.findByProductIdWithMinPrice(data.getId());
                if (productSkusEntity != null) {
                    productResponse.setPrice(productSkusEntity.getPrice());
                    productResponse.setQuantity(productSkusEntity.getQuantity());
                } else {
                    // Handle the case when productSkusEntity is null
                    // For example, you can set default values
                    productResponse.setPrice(0);
                    productResponse.setQuantity(0);
                }

                List<ImageEntity> listImage = imageRepository.findAllByProductSkusId(data.getId());
                List<String> imageList = new ArrayList<>();
                if (listImage != null) {
                    for (ImageEntity imageEntity : listImage) {
                        imageList.add(imageEntity.getSource());
                    }
                } else {
                    // Handle the case when listImage is null
                    // For example, you can add a default image source
                    imageList.add("default_image_source");
                }
                productResponse.setImage(imageList);
                productResponseList.add(productResponse);
            }
        } catch (Exception e) {
            throw new CustomException("Error findAllProduct in ProductService " + e.getMessage());
        }
        return productResponseList;
    }
//
//    @Override
//    public List<ProductResponse> getProductByCategoryName(String name) {
//        List <ProductResponse> responses = new ArrayList<>();
//        try {
//            List <ProductEntity> entityList = productRepository.findByCategoryName(name);
//
//            for (ProductEntity data : entityList) {
//                ProductResponse productResponse1 = new ProductResponse();
//                productResponse1.setId(data.getId());
//                productResponse1.setPrice(data.getPrice());
//                productResponse1.setName(data.getName());
//                productResponse1.setDescription(data.getDescription());
//                productResponse1.setCategory(data.getCategory().getName());
//                productResponse1.setQuantity(data.getQuantity());
//
//                // Get image source list and pass to productResponse
//                List<ImageEntity> imageList = imageRepository.findByProductId(data.getId());
//                List<String> imageSource = new ArrayList<>();
//                for (ImageEntity imageEntity : imageList) {
//                    imageSource.add(imageEntity.getSource());
//                }
//
//                productResponse1.setImage(imageSource);
//                responses.add(productResponse1);
//            }
//
//
//        } catch (Exception e) {
//            throw new CustomException("Error getProductById in ProductService" + e.getMessage());
//        }
//        return responses;
//    }
}
