package com.ujs.iot.service;


import com.ujs.iot.entity.User;

/**
 *  @author: Zhong Linfeng
 *  @Date: 2022/1/29 23:11
 *  @Description:
 */ 
public interface UserService {

    User SelectByUsername(String username);
}
