package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.entity.SizeEntity;

import java.util.List;

public interface SizeServiceImp {
    List<SizeEntity> findAllSizeByProductName(String name);
}
