package com.ujs.iot.controller;

import com.ujs.iot.common.config.GlobalResult;
import com.ujs.iot.entity.Product;
import com.ujs.iot.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:00
 * @Description:
 */

@Api(tags = "物联网云产品服务")
@RestController
@RequestMapping("/product")
@CrossOrigin

public class ProductController {

    @Autowired
    ProductService productService;

    String str = "a0A0b1B2c1C3d2D1e3E2f4F3g5G7h4H6i5Ij4J9k5K6l6Lm7M7n8N8o9Op0PqQrRsStTuUv9VwWxXy8YzZ";

    @PostMapping("/createProduct")
    @ApiOperation(value = "创建产品")
    public GlobalResult createProduct(@RequestParam String productName,@RequestParam String productType,@RequestParam String productMessage) {

        GlobalResult result;
        if (productService.getProductdetail(productName)!=null) {
            result = GlobalResult.build(500, "该产品已存在", null);
        }
        else {
            Product product = new Product();
            product.setProductName(productName);

            String ProductKey=RandomStringUtils.random(10,str);
            product.setProductKey(ProductKey);

            String productSecret=RandomStringUtils.random(16,str);
            product.setProductSecret(productSecret);

            product.setProductType(productType);
            Date date = new Date(System.currentTimeMillis());
            product.setCreateTime(date);
            product.setProductMessage(productMessage);
            productService.createProduct(product);
            try {
                result = GlobalResult.build(200, "产品创建成功",null);
            }
            catch (Exception e){
                result = GlobalResult.build(500, "产品创建失败",null);
            }
        }
        return result;
    }

    @GetMapping("/getProduct")
    @ApiOperation(value = "获取产品信息")
    public GlobalResult getProduct(@RequestParam int pageIndex,@RequestParam int pageSize){
        GlobalResult result;
       int start=(pageIndex-1)*pageSize;

       try {
           List<Product> product = productService.getProduct(start,pageSize);
           int length=productService.getProductCount();
           if (product!=null)
               result = GlobalResult.build(200, String.valueOf(length),product);
           else result = GlobalResult.build(500, "无产品信息", null);
       }
       catch (Exception e ){
           result = GlobalResult.build(500, "查询产品信息失败", null);
       }

        return result;
    }


    @PostMapping("/deleteProduct")
    @ApiOperation(value = "删除产品")
    public GlobalResult deleteProduct(@RequestParam String productKey) {
        GlobalResult result ;
        try {
            productService.deleteProduct(productKey);
            result = GlobalResult.build(200, "删除产品成功",null);
        }
        catch (Exception e){
            result = GlobalResult.build(500, "删除产品失败",null);
        }
        return result;
    }

    @PostMapping("/checkProduct")
    @ApiOperation(value = "查看产品详细信息")
    public GlobalResult checkProduct(@RequestParam String productName) {
        GlobalResult result;
        try {
            Product product=productService.getProductdetail(productName);
            result=GlobalResult.build(200, "产品信息获取成功",product);
        }
        catch (Exception e){
            result = GlobalResult.build(200, "产品信息获取失败",null);
        }
        return result;
    }

    @GetMapping("/getAllProduct")
    @ApiOperation(value = "查看所有产品信息")
    public GlobalResult getAllProduct() {
        GlobalResult result;
        try {
            List<Product> product=productService.getAllProduct();
            result=GlobalResult.build(200, "产品信息获取成功",product);
        }
        catch (Exception e){
            result = GlobalResult.build(200, "产品信息获取失败",null);
        }
        return result;
    }
}
