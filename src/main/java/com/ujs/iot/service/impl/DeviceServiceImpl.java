package com.ujs.iot.service.impl;

import com.ujs.iot.entity.Device;

import com.ujs.iot.dao.DeviceMapper;
import com.ujs.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public void createDevice(Device device) {
        deviceMapper.createDevice(device);
    }

    @Override
    public void updateclientId(String deviceName,String clientId){
        deviceMapper.updateclientId(deviceName,clientId);
    }

    @Override
    public Device autheDevice(String deviceName,String deviceSecret){
        return deviceMapper.autheDevice(deviceName,deviceSecret);
    }

    @Override
    public void updateStatus(String clientId,String status){
        deviceMapper.updateStatus(clientId,status);
    }

    @Override
    public int getDeviceCount(){
        return deviceMapper.getDeviceCount();
    }

    @Override
    public  List<Device> getDevices(int start,int pageSize){
        return deviceMapper.getDevices(start,pageSize);
    }

    @Override
    public List<Device> getProductDevices(String productKey){
        return deviceMapper.getProductDevices(productKey);
    }

    @Override
    public Device getDevice(String deviceName,String productKey){
        return deviceMapper.getDevice(deviceName, productKey);
    }

    @Override
    public void deleteDevice(String deviceName,String productKey){
        deviceMapper.deleteDevice( deviceName, productKey);
    }

    @Override
    public Device getDeviceClientId (String clientId){
        return deviceMapper.getDeviceClientId(clientId);
    }
}
