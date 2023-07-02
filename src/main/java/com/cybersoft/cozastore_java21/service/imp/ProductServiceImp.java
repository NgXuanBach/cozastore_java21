package com.cybersoft.cozastore_java21.service.imp;

import com.cybersoft.cozastore_java21.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int id);
}
