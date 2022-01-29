package com.ujs.iot.common.security;


import com.alibaba.fastjson.JSON;

import com.ujs.iot.common.Enums.ResultEnum;
import com.ujs.iot.common.VO.ResultVO;
import com.ujs.iot.common.utils.JwtTokenUtil;
import com.ujs.iot.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  @author: Zhong Linfeng
 *  @Date: 2022/1/29 23:06
 *  @Description: 用户登录成功时返回给前端的数据
 */
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User userDetails = (User) authentication.getPrincipal();

        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), 1500,null);

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));
    }
}