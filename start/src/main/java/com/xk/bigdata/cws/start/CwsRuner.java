package com.xk.bigdata.cws.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author: xiankai
 * Date: 2021/8/6 19:21
 */
@EntityScan("com.xk.bigdata.cws")
@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.xk.bigdata"})
@EnableJpaRepositories(basePackages = "com.xk.bigdata.cws")
public class CwsRuner  extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CwsRuner.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CwsRuner.class, args);
    }
}
