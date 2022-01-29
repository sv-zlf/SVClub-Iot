package com.ujs.iot.service.impl;

import com.ujs.iot.entity.Product;
import com.ujs.iot.dao.ProductMapper;
import com.ujs.iot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 13754
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:44
 * @Description:
 */

@Service
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;

    @Override
    public void createProduct(Product product) {
        productMapper.createProduct(product);
        System.out.println("创建产品");
    }

    @Override
    public List<Product> getProduct(int start,int pageSize){
        return productMapper.getProduct(start,pageSize);
    }

    @Override
    public  void deleteProduct(String productKey){
        productMapper.deleteProduct(productKey);
    }

    @Override
    public Product getProductdetail(String productName){
        return productMapper.getProductdetail(productName);
    }

    @Override
    public int getProductCount(){
        return productMapper.getProductCount();
    }

    @Override
    public List<Product> getAllProduct(){
        return productMapper.getAllProduct();
    }


}
