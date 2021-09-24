package com.xk.bigdata.cws.common.tools.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午10:25
 */
public class CwsUtils {

    public static <T, K> T pojoTrans(K k, Class<T> clazz) {
        if (k == null)
            return null;
        String s = JSONObject.toJSONString(k);
        return JSONObject.parseObject(s, clazz);
    }

    public static <T, K> List<T> pojoListTrans(List<K> ks, Class<T> clazz) {
        if (ks == null || ks.size() == 0)
            return Collections.emptyList();
        List<T> res = ks.stream().map(k -> pojoTrans(k, clazz)).collect(Collectors.toList());
        return res;
    }

    public static boolean isEmpty(String s){
         return s == null || "".equals(s);
    }
    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }

    //后面改成从session获取
    public static Integer getUserId(){
        return 1;
    }
}
