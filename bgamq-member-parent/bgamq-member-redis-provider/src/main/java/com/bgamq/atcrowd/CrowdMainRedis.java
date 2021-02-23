package com.bgamq.atcrowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrowdMainRedis {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMainRedis.class,args);
    }
}
