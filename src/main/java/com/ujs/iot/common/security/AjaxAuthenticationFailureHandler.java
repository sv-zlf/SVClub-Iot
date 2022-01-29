package com.ujs.iot.common.security;


import com.alibaba.fastjson.JSON;

import com.ujs.iot.common.Enums.ResultEnum;
import com.ujs.iot.common.VO.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *  @author: Zhong Linfeng
 *  @Date: 2022/1/29 22:57
 *  @Description: 用户登录失败时返回给前端的数据
 */
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_FAILED,false)));
    }

}