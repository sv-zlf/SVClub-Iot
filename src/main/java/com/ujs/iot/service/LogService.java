package com.ujs.iot.service;

import com.ujs.iot.entity.Log;

import java.util.List;

public interface LogService {

    void insertMessage(Log log);

    List<Log> getAlllog();
}
