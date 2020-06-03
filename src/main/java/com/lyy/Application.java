package com.lyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description:com.lyy
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */
@MapperScan("com.lyy.mapper")//用于扫描mybatis的mapper接口，根据扫描的接口生成代理对象
@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
