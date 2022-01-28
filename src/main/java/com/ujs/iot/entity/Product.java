package com.ujs.iot.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author 13754
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:03
 * @Description:
 */

@Data
public class Product {

    private String productName;

    private String productKey;

    private String productSecret;

    private String productType;

    private Date createTime;

    private String productMessage;

}
