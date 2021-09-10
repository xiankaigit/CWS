package com.xk.bigdata.cws.sql.parser.calcite;

import com.xk.bigdata.cws.common.tools.engine.Engine;
import com.xk.bigdata.cws.common.tools.exception.SqlParseExeception;
import com.xk.bigdata.cws.sql.parser.BaseSqlParser;
import javafx.util.Pair;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 下午3:27
 */
public class SmartSqlParse implements BaseSqlParser {
    @Override
    public Pair<Engine, String> parseSql(String sql) {
        throw new SqlParseExeception("SmartSqlParse is not currently supported");
    }
}
