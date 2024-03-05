package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.BlogResponse;

import java.util.List;

public interface BlogServiceImp {
    List<BlogResponse> findAllBlog();
}
