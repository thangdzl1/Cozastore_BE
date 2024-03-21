package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.entity.SizeEntity;
import com.cybersoft.cozastore.payload.response.SizeResponse;

import java.util.List;

public interface SizeServiceImp {
    List<SizeResponse> findAllSizeByProductName(String name);
}
