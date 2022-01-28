package com.ujs.iot.entity;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Log {


    private int MessageId;

    private String Message;

    private String DeviceName;

    private String MessageType;

    private Date time;

    private String productKey;


}

