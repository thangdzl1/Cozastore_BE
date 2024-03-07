package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.CommentEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.payload.request.CommentRequest;
import com.cybersoft.cozastore.repository.BlogRepository;
import com.cybersoft.cozastore.repository.CommentRepository;
import com.cybersoft.cozastore.service.Imp.CommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CommentServiceImp {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public boolean addComment(CommentRequest commentRequest){
        boolean isSuccess = false;
        try {
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setBlog(blogRepository.getReferenceById(commentRequest.getBlog_id()));
            commentEntity.setComment(commentRequest.getComment());
            commentEntity.setName(commentRequest.getName());
            commentEntity.setEmail(commentRequest.getEmail());
            commentEntity.setWebsite(commentRequest.getWebsite());
            commentEntity.setCreateDate(commentRequest.getDate());
            commentRepository.save(commentEntity);
            isSuccess = true;
        }catch (Exception e){
            throw new CustomException("Error addComment in CommentService " + e.getMessage());
        }
        return isSuccess;
    }
}
