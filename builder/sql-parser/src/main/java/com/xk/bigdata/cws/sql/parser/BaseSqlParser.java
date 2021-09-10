package com.xk.bigdata.cws.sql.parser;

import com.xk.bigdata.cws.common.tools.engine.Engine;
import javafx.util.Pair;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午9:53
 * @describe : sql解析器，获得目标引擎和sql,计划支持两种解析器：
 *              RuleSqlParse: 基于规则的解析, 每条sql的通过关键字for指明目标引擎，通过这个规则去解析；过度期间使用，因为工作量小
 *              SmartSqlParse: 基于calcite进行智能解析，支持通过解析自定义关键字for识别目标引擎，同时支持分析sql推断适合的引擎
 *                             需要在calcite上扩充语法，适配不同的引擎，开发工作量较大，具体支持时间待定
 *
 */
public interface BaseSqlParser {

    Pair<Engine, String> parseSql(String sql);
}
