package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.UCartItemEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.UCartItemResponse;
import com.cybersoft.cozastore.repository.UCartItemRepository;
import com.cybersoft.cozastore.service.Imp.UCartItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UCartItemService implements UCartItemServiceImp {
    @Autowired
    private UCartItemRepository uCartItemRepository;

    @Override
    public List<UCartItemResponse> findAllUCartItemByCartId(int id) {
        List<UCartItemResponse> list = new ArrayList<>();
        try {
            List<UCartItemEntity> responseList = uCartItemRepository.findAllByUCartId(id);
            for (UCartItemEntity uCartItemEntity : responseList) {
                UCartItemResponse uCartItemResponse = new UCartItemResponse();
                uCartItemResponse.setId(uCartItemEntity.getId());
                uCartItemResponse.setProductName(uCartItemEntity.getProductSkus().getProduct().getName());
                uCartItemResponse.setPrice(uCartItemEntity.getProductSkus().getPrice());
                uCartItemResponse.setQuantity(uCartItemEntity.getQuantity());
                uCartItemResponse.setImage(uCartItemEntity.getProductSkus().getProduct().getImage());
                list.add(uCartItemResponse);
            }
        } catch (Exception e) {
            throw new CustomException("Error at findAllUCartItemByCartId in UCartItemService" + e.getMessage());
        }
        return list;
    }
}
