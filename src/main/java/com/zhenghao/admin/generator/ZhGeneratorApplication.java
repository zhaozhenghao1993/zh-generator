package com.zhenghao.admin.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhenghao.admin.**.dao")
public class ZhGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhGeneratorApplication.class, args);
    }

}
