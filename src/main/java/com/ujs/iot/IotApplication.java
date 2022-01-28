package com.ujs.iot;

import com.ujs.iot.mqttx.broker.BrokerInitializer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.ujs.iot.Mapper")
public class IotApplication {

    public static void main(String[] args) throws InterruptedException{


        ConfigurableApplicationContext ctx = SpringApplication.run(IotApplication.class, args);

        //启动mqtt
        ctx.getBean(BrokerInitializer.class).start();
    }

}
