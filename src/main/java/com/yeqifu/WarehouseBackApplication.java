package com.yeqifu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.yeqifu.system.mapper"})
/**
 * @Author: 落亦-
 * @Date: 2020/1/30 10:26
 */
public class WarehouseBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseBackApplication.class, args);
    }

}
