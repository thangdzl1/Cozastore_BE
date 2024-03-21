package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.SizeEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.SizeResponse;
import com.cybersoft.cozastore.repository.SizeRepository;
import com.cybersoft.cozastore.service.Imp.SizeServiceImp;
import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SizeService implements SizeServiceImp {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<SizeResponse> findAllSizeByProductName(String name) {
        try{
            List<SizeEntity> sizeEntity = sizeRepository.findAllByProductName(name);
            List<SizeResponse> list = new ArrayList<>();
            for (SizeEntity data: sizeEntity
                 ) {
                SizeResponse response = new SizeResponse();
                response.setName(data.getName());
                response.setId(data.getId());
                list.add(response);
            }
            return list;

        }catch (Exception e){
            throw new CustomException("Error findAllSizeByProductName in SizeService " + e.getMessage());
        }
    }
}
