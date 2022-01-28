package com.ujs.iot.controller;

import com.ujs.iot.common.config.GlobalResult;
import com.ujs.iot.entity.Device;
import com.ujs.iot.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * @author 13754
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 10:40
 * @Description:
 */

@Api(tags = "物联网云设备服务")
@RestController
@RequestMapping("/device")
@CrossOrigin

public class DeviceController {

    @Autowired
    DeviceService deviceService;

    String str = "a0A0b1B2c1C3d2D1e3E2f4F3g5G7h4H6i5Ij4J9k5K6l6Lm7M7n8N8o9Op0PqQrRsStTuUv9VwWxXy8YzZ";

    @PostMapping("/createDevice")
    @ApiOperation(value = "创建设备")
    public GlobalResult createDevice(@RequestParam String deviceName,@RequestParam String productKey) {

        GlobalResult result;
        if (deviceService.getDevice(deviceName,productKey)!=null)
            return  GlobalResult.build(500, "该设备已存在",null);
        else{
            Device device=new Device();
            device.setDeviceName(deviceName);
            device.setProductKey(productKey);

            String deviceSecret= RandomStringUtils.random(16,str);
            device.setDeviceSecret(deviceSecret);

            Date date = new Date(System.currentTimeMillis());
            device.setCreateTime(date);
            device.setDeviceType("设备");
            device.setDeviceStatus("未激活");

            try {
                deviceService.createDevice(device);
                result = GlobalResult.build(200, "设备创建成功",null);
            }
            catch (Exception e){
                e.printStackTrace();
                result = GlobalResult.build(500, "设备创建失败",null);
            }
        }

        return result;
    }

    @PostMapping("/deleteDevice")
    @ApiOperation(value = "删除设备")
    public GlobalResult deleteDevice(@RequestParam String deviceName,@RequestParam String productKey) {
        GlobalResult result;
        try {
            deviceService.deleteDevice(deviceName,productKey);
            result = GlobalResult.build(200, "设备已删除",null);
        }
        catch (Exception e){
            result = GlobalResult.build(500, "删除设备失败",null);
        }
        return result;
    }

    @PostMapping("/getDevices")
    @ApiOperation(value = "查看设备")
    public GlobalResult getDevices(@RequestParam int pageIndex,@RequestParam int pageSize) {

        GlobalResult result;
        int start=(pageIndex-1)*pageSize;
        try {
            List<Device> device = deviceService.getDevices(start,pageSize);
            int length=deviceService.getDeviceCount();
            if (device!=null)
                result = GlobalResult.build(200, String.valueOf(length),device);
            else result = GlobalResult.build(500, "无设备信息", null);
        }
        catch (Exception e){
            result = GlobalResult.build(500, "设备信息查询失败",null);
        }
        return result;
    }

    @PostMapping("/checkDevice")
    @ApiOperation(value = "查看设备")
    public GlobalResult checkDevice(@RequestParam String deviceName,@RequestParam String productKey) {

        GlobalResult result;

        try {
            Device device=deviceService.getDevice(deviceName,productKey);
            result = GlobalResult.build(200, "设备查询成功",device);
        }
        catch (Exception e){
            result = GlobalResult.build(500, "设备查询失败",null);
        }

        return result;
    }
    @PostMapping("/getProductDevices")
    @ApiOperation(value = "查看指定产品设备")
    public GlobalResult getProductDevices(@RequestParam String productKey) {

        GlobalResult result;

        try {
            List<Device> devices=deviceService.getProductDevices(productKey);
            result  = GlobalResult.build(200, "获取指定产品设备信息成功",devices);
        }
        catch (Exception e){
            result  = GlobalResult.build(500, "获取产品设备信息失败",null);
        }

        return result;
    }

}
