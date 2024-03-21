package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.SizeEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.repository.SizeRepository;
import com.cybersoft.cozastore.service.Imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeService implements SizeServiceImp {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<SizeEntity> findAllSizeByProductName(String name) {
        try{
            return sizeRepository.findAllByProductName(name);
        }catch (Exception e){
            throw new CustomException("Error findAllSizeByProductName in SizeService " + e.getMessage());
        }
    }
}
