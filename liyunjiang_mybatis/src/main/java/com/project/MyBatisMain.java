package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.project.dao")
public class MyBatisMain {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisMain.class);
    }
}
