package com.xk.bigdata.cws.common.tools.engine;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 下午2:52
 */
public class SupportEngineTool {

    private static final Map<String,Engine> NAME_TO_ENGINE =  new HashMap<>();
    private static final Map<Engine,String> ENGINE_TO_NAME =  new HashMap<>();

    static {
        Engine[] engines = Engine.values();
        for (Engine engine : engines) {
            String name = engine.name();
            NAME_TO_ENGINE.put(name,engine);
            ENGINE_TO_NAME.put(engine,name);
        }
    }

    public static Engine toEngine(String name){
        if(StringUtils.isEmpty(name))
            return null;
        return NAME_TO_ENGINE.get(name.toUpperCase());

    }

    public static void main(String[] args) {
        Engine[] values = Engine.values();
        for (Engine value : values) {
            String name = value.name();
            System.out.println(name);
        }
    }

}
