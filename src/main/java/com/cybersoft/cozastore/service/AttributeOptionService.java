package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.AttributeOptionEntity;
import com.cybersoft.cozastore.entity.BlogEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.AttributesOptionResponse;
import com.cybersoft.cozastore.payload.response.BlogResponse;
import com.cybersoft.cozastore.repository.AttributeOptionsRepository;
import com.cybersoft.cozastore.service.Imp.AttributeOptionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeOptionService implements AttributeOptionServiceImp {
    @Autowired
    private AttributeOptionsRepository attributeOptionsRepository;

    @Override
    public List<AttributesOptionResponse> findAllByAttributeIdAndProductId(int attributeId, int productId) {
        List<AttributesOptionResponse> responseList = new ArrayList<>();

        try {
            List<AttributeOptionEntity> entityList = attributeOptionsRepository.findAllByAttributeIdAndProductId(attributeId, productId);
            for (AttributeOptionEntity data : entityList
            ) {
                AttributesOptionResponse response = new AttributesOptionResponse();
                response.setId(data.getId());
                response.setValue(data.getValue());
                response.setAttributeId(data.getAttribute().getId());

                responseList.add(response);
            }
            return responseList;
        } catch (
                Exception e) {
            throw new CustomException("Error findAllByAttributeIdAndProductId at AttributeOptionService " + e.getMessage());
        }
    }

    @Override
    public List<AttributesOptionResponse> findAllByProductSkusId(int id) {
        List<AttributesOptionResponse> responseList = new ArrayList<>();

        try {
            List<AttributeOptionEntity> entityList = attributeOptionsRepository.findAllByProductSkusId(id);
            for (AttributeOptionEntity data : entityList
            ) {
                AttributesOptionResponse response = new AttributesOptionResponse();
                response.setId(data.getId());
                response.setValue(data.getValue());
                response.setAttributeId(data.getAttribute().getId());

                responseList.add(response);
            }
            return responseList;
        } catch (
                Exception e) {
            throw new CustomException("Error findAllByAttributeIdAndProductId at findAllByProductSkusId " + e.getMessage());
        }
    }
}
