package com.ujs.iot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 13754
 * @Auther: 钟林锋
 * @Date: 2021 12) 28) 11:03
 * @Description:
 */

@Data

public class Device {

    private String deviceName;

    private String deviceType;

    private String productKey;

    private String deviceSecret;

    private String deviceStatus;

    private Date createTime;

    private String clientId;
}
