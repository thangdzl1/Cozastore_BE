package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.AttributesOptionResponse;

import java.util.List;

public interface AttributeOptionServiceImp {
    List<AttributesOptionResponse> findAllByAttributeIdAndProductId(int attributeId, int productId);
    List<AttributesOptionResponse> findAllByProductSkusId(int id);
}
