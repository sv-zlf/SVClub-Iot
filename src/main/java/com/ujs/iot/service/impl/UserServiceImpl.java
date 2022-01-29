package com.ujs.iot.service.impl;

import com.ujs.iot.dao.UserMapper;
import com.ujs.iot.entity.User;
import com.ujs.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  @author: Zhong Linfeng
 *  @Date: 2022/1/29 23:11
 *  @Description:
 */
@Service
public class UserServiceImpl implements UserService {


    UserMapper userMapper;

    @Override
    public User SelectByUsername(String username){
        return userMapper.SelectByUsername(username);
    }
}
