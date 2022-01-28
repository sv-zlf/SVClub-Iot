package com.ujs.iot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 13754
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:10
 * @Description:
 */

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private Date updateTime;

}
