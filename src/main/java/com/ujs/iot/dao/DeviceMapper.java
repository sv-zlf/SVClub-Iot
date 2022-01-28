package com.ujs.iot.dao;

import com.ujs.iot.entity.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:28
 * @Description:
 */

@Mapper
public interface DeviceMapper {

    @Insert("insert into device(deviceName, productKey,deviceSecret,deviceType,createTime,deviceStatus,clientId) values(#{deviceName}, #{productKey},#{deviceSecret},#{deviceType},#{createTime},#{deviceStatus},#{clientId})")
    void createDevice(Device device);

    @Select("select * from device where deviceName = #{deviceName} and deviceSecret=#{deviceSecret}")
    Device autheDevice(@Param("deviceName")String deviceName,@Param("deviceSecret")String deviceSecret);

    @Update("update device set deviceStatus=#{deviceStatus} where clientId=#{clientId} ")
    void updateStatus(@Param("clientId")String clientId,@Param("deviceStatus")String deviceStatus);

    @Update("update device set clientId=#{clientId} where deviceName=#{deviceName} ")
    void updateclientId(@Param("deviceName")String deviceName,@Param("clientId")String clientId);

    @Select("select * from device limit #{start} ,#{pageSize}")
    List<Device> getDevices(@Param("start")int start, @Param("pageSize")int pageSize);

    @Select("select count(*) from device ")
    int getDeviceCount();

    @Select("select * from device where productKey=#{productKey}")
    List<Device> getProductDevices(@Param("productKey")String productKey);

    @Select("select * from device where deviceName=#{deviceName} and productKey=#{productKey}")
    Device getDevice(@Param("deviceName")String deviceName,@Param("productKey")String productKey);

    @Delete("delete  from device where deviceName=#{deviceName} and productKey=#{productKey}")
    void deleteDevice(@Param("deviceName")String deviceName,@Param("productKey")String productKey);

    @Select("select * from device where clientId=#{clientId}")
    Device getDeviceClientId(@Param("clientId")String clientId);
}
