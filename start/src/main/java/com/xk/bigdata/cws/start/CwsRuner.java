package com.xk.bigdata.cws.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Author: xiankai
 * Date: 2021/8/6 19:21
 */
@SpringBootApplication(scanBasePackages = {"com.xk.bigdata"})
public class CwsRuner {

    public static void main(String[] args) {
        SpringApplication.run(CwsRuner.class, args);
    }
}
