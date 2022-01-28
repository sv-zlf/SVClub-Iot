package com.ujs.iot.dao;

import com.ujs.iot.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Insert("insert into log(Message, MessageId,DeviceName,MessageType,time,productKey) values(#{Message}, #{MessageId},#{DeviceName},#{MessageType},#{time},#{productKey})")
    void insertMessage(Log log);

    @Select("select * from log")
    List<Log> getAlllog();
}
