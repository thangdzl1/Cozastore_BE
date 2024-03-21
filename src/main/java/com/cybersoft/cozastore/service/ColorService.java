package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ColorEntity;
import com.cybersoft.cozastore.entity.SizeEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.ColorResponse;
import com.cybersoft.cozastore.payload.response.SizeResponse;
import com.cybersoft.cozastore.repository.ColorRepository;
import com.cybersoft.cozastore.service.Imp.ColorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService implements ColorServiceImp {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<ColorResponse> findAllColorByProductName(String name) {
        try{
            List<ColorEntity> listResponse = colorRepository.findAllByProductName(name);
            List<ColorResponse> list = new ArrayList<>();
            for (ColorEntity data: listResponse
            ) {
                ColorResponse response = new ColorResponse();
                response.setName(data.getName());
                response.setId(data.getId());
                list.add(response);
            }
            return list;

        }catch (Exception e){
            throw new CustomException("Error findAllColorByProductName in ColorService " + e.getMessage());
        }
    }
}
