package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.entity.ArchiveEntity;
import com.cybersoft.cozastore.payload.response.AttributesOptionResponse;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.AttributeOptionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attribute")
public class AttributeController {

    @Autowired
    private AttributeOptionServiceImp attributeOptionServiceImp;

    @PostMapping("/options")
    ResponseEntity<?> findAllArchive(
            @RequestParam int attributeId,
            @RequestParam int productId){
        List<AttributesOptionResponse> list = attributeOptionServiceImp.findAllByAttributeIdAndProductId(attributeId, productId);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
