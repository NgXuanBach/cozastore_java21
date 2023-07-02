package com.cybersoft.cozastore_java21.service.imp;

import com.cybersoft.cozastore_java21.entity.ProductEntity;
import com.cybersoft.cozastore_java21.payload.response.ProductResponse;
import com.cybersoft.cozastore_java21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> responseList = new ArrayList<>();
        for (ProductEntity data :
                list) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(data.getPrice());
            responseList.add(productResponse);
        }
        return responseList;
    }
}
