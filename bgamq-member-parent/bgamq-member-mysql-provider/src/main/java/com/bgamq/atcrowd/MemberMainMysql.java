package com.bgamq.atcrowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bgamq.atcrowd.mapper")
@SpringBootApplication
public class MemberMainMysql {
    public static void main(String[] args) {

        SpringApplication.run(MemberMainMysql.class,args);
    }
}
