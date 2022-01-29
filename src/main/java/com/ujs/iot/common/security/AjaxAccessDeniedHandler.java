package com.ujs.iot.common.security;


import com.alibaba.fastjson.JSON;

import com.ujs.iot.common.Enums.ResultEnum;
import com.ujs.iot.common.VO.ResultVO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 *  @author: Zhong Linfeng
 *  @Date: 2022/1/29 1:45
 *  @Description: 无权访问
 */
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NO_ACCESS,false)));
    }
}