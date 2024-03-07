package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.request.CommentRequest;

public interface CommentServiceImp {
    boolean addComment(CommentRequest commentRequest);
}
