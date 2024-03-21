package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.ColorResponse;

import java.util.List;

public interface ColorServiceImp {
    List<ColorResponse> findAllColorByProductName(String name);
}
