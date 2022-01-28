package com.ujs.iot.service;

import com.ujs.iot.entity.Product;

import java.util.List;

/**
 * @author 13754
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:42
 * @Description:
 */

public interface ProductService {

    void createProduct(Product product);

    List<Product> getProduct(int start,int pageSize);

    void deleteProduct(String productKey);

    Product getProductdetail(String productName);

    int getProductCount();

    List<Product> getAllProduct();
}
