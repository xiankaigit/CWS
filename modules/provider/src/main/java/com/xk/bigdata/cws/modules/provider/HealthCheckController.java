package com.xk.bigdata.cws.modules.provider;

import com.xk.bigdata.cws.api.IHealthCheck;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: xiankai
 * Date: 2021/8/6 19:46
 */
@Component
public class HealthCheckController implements IHealthCheck {

    public HealthCheckController() {
        System.out.println("=====controller======");
    }

    @Override
    public Map<String, Object> healthCheck() {
        System.out.println("我收到了一个请求");
        Map<String,Object> map = new HashMap<>();
        map.put("status","running");
        return map;
    }
}
