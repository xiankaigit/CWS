package com.xk.bigdata.cws.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author: xiankai
 * Date: 2021/8/6 19:21
 */
@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.xk.bigdata"})
public class CwsRuner  extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CwsRuner.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CwsRuner.class, args);
    }
}
