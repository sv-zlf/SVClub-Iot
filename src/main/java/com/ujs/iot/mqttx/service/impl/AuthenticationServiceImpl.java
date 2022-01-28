package com.ujs.iot.mqttx.service.impl;


import com.ujs.iot.entity.Device;
import com.ujs.iot.mqttx.entity.Authentication;
import com.ujs.iot.mqttx.exception.AuthenticationException;
import com.ujs.iot.mqttx.exception.AuthorizationException;
import com.ujs.iot.mqttx.service.IAuthenticationService;
import com.ujs.iot.service.DeviceService;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 认证服务
 *
 * @author Jun
 * @date 2020-03-04 12:44
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    DeviceService deviceService;

    @Override
    public Authentication authenticate(String username, String password) throws AuthenticationException, AuthorizationException {

        try {
            Device device=deviceService.autheDevice(username,password);
            if (device==null)
                throw new AuthenticationException("密码校验不通过");

        }
        catch (BindingException e){
           throw new AuthenticationException("密码校验不通过");
        }
        return null;
    }
}
