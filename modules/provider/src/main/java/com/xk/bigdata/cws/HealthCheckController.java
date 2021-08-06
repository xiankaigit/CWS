package com.xk.bigdata.cws;

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
    public Map<String, Object> healthCheck(Map<String,Object> data) {
        Map<String,Object> map = new HashMap<>();
        map.put("status","running");
        return map;
    }
}
