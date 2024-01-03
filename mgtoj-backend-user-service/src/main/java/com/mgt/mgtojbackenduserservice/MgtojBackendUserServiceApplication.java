package com.mgt.mgtojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.mgt.mgtojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.mgt")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.mgt.mgtojbackendserviceclient.service"})
public class MgtojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgtojBackendUserServiceApplication.class, args);
    }

}
