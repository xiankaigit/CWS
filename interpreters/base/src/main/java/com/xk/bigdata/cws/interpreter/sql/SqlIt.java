package com.xk.bigdata.cws.interpreter.sql;

import com.xk.bigdata.cws.interpreter.result.ExeRes;

import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/24 下午2:09
 */
public interface SqlIt {

    ExeRes run(List<String> sqlList, Integer itId);

}
