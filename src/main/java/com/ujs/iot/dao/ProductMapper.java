package com.ujs.iot.dao;

import com.ujs.iot.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:33
 * @Description:
 */

@Mapper
public interface ProductMapper {

    @Insert("insert into product(productName, productKey,productSecret,productType,createTime,productMessage) values(#{productName}, #{productKey},#{productSecret},#{productType},#{createTime},#{productMessage})")
    void createProduct(Product product);

    @Select("select * from product limit #{start} ,#{pageSize}")
    List<Product> getProduct(@Param("start")int start, @Param("pageSize")int pageSize);

    @Delete("delete from product where  productKey=#{productKey}")
    void deleteProduct(@Param("productKey")String productKey);

    @Select("select * from product where productName=#{productName}")
    Product getProductdetail(@Param("productName")String productName);

    @Select("select count(*) from product ")
    int getProductCount();

    @Select("select * from product")
    List<Product> getAllProduct();
}
