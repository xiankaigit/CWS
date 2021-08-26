package com.xk.bigdata.cws;

import org.apache.http.HttpRequest;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: xiankai
 * Date: 2021/8/6 19:46
 */
@Component
public class HealthCheckController implements IHealthCheck {


    @Override
    public Map<String, Object> healthCheck() {
        System.out.println("我收到了一个请求");
        Map<String,Object> map = new HashMap<>();
        map.put("status","running");
        return map;
    }
}
