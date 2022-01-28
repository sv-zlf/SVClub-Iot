package com.ujs.iot.controller;

import com.ujs.iot.common.config.GlobalResult;
import com.ujs.iot.entity.Log;
import com.ujs.iot.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "物联网云日志服务")
@RestController
@RequestMapping("/log")
@CrossOrigin
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping("/getAlllog")
    @ApiOperation(value ="获取日志信息")
    public   GlobalResult createDevice() {
        GlobalResult result;
        try {
           List<Log> logs= logService.getAlllog();
            result= GlobalResult.build(200, "查询日志成功",logs);
        }
        catch (Exception e){
            result= GlobalResult.build(500, "查询日志失败",null);
        }
        return result;
    }
}
