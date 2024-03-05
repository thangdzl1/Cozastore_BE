package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.entity.TagEntity;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.service.Imp.TagServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagServiceImp tagServiceImp;

    @GetMapping("")
    ResponseEntity<?> findAllTag(){
        List<TagEntity> list = tagServiceImp.findAll();

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    ResponseEntity<?> findAllTagByBlogId(@PathVariable int id){
        List<TagEntity> list = tagServiceImp.findAllTagByBlogId(id);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
