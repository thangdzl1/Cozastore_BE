package com.cybersoft.cozastore.service.Imp;

import com.cybersoft.cozastore.payload.response.UCartItemResponse;

import java.util.List;

public interface UCartItemServiceImp {
    List<UCartItemResponse> findAllUCartItemByCartId(int id);
}
