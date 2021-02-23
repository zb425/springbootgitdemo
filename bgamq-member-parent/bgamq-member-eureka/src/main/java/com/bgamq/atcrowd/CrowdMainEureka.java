package com.bgamq.atcrowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CrowdMainEureka {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMainEureka.class,args);
    }
}
