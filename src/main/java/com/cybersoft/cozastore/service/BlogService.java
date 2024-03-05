package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.BlogEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.response.BlogResponse;
import com.cybersoft.cozastore.repository.BlogRepository;
import com.cybersoft.cozastore.service.Imp.BlogServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements BlogServiceImp {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<BlogResponse> findAllBlog(){
        List<BlogResponse> responseList = new ArrayList<>();

        try{
            List<BlogEntity> entityList = blogRepository.findAll();
            for (BlogEntity data: entityList
                 ) {
                BlogResponse blogResponse = new BlogResponse();
                blogResponse.setContent(data.getContent());
                blogResponse.setDescription(data.getDescription());
                blogResponse.setCreate_date(data.getCreateDate());
                blogResponse.setTitle(data.getTitle());
                blogResponse.setContent(data.getContent());

                responseList.add(blogResponse);
            }
            return responseList;
        }catch (Exception e){
            throw new CustomException("Error findAllBlog in BlogService " + e.getMessage());
        }
    }
}
