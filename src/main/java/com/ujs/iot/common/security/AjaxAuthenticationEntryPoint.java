package com.ujs.iot.common.security;

import com.alibaba.fastjson.JSON;

import com.ujs.iot.common.Enums.ResultEnum;
import com.ujs.iot.common.VO.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 *  @author: Zhong Linfeng
 *  @Date: 2022/1/29 1:37
 *  @Description: 用户未登录时返回给前端的数据
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}
