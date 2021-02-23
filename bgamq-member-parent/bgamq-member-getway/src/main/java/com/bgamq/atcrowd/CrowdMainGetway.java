package com.bgamq.atcrowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class CrowdMainGetway {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMainGetway.class,args);
    }
}
