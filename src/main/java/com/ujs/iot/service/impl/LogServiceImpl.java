package com.ujs.iot.service.impl;

import com.ujs.iot.entity.Log;
import com.ujs.iot.dao.LogMapper;
import com.ujs.iot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public void insertMessage(Log log){
        logMapper.insertMessage(log);
    }

    @Override
    public List<Log> getAlllog(){
        return logMapper.getAlllog();
    }
}
