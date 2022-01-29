package com.ujs.iot.dao;


import com.ujs.iot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User SelectByUsername(@Param("username")String username);
}
