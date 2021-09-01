package com.xk.bigdata.cws.moudles.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/hhh")
@Controller
public class MvcController {

    @GetMapping("/get")
    @RequestMapping("get")
    @ResponseBody
    public Map get(){
        Map<String,Object> res = new HashMap<>();
        res.put("key","val");
        return res;
    }

}
