package com.xk.bigdata.cws.sql.parser.rule;

import com.xk.bigdata.cws.common.tools.engine.Engine;
import com.xk.bigdata.cws.common.tools.engine.SupportEngineTool;
import com.xk.bigdata.cws.common.tools.exception.SqlParseExeception;
import com.xk.bigdata.cws.common.tools.validate.ValidateParam;
import com.xk.bigdata.cws.sql.parser.BaseSqlParser;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/10 上午10:20
 */
public class RuleSqlParse implements BaseSqlParser {


    private static Logger LOG = LoggerFactory.getLogger(RuleSqlParse.class);

    private static final String FOR = "for";

    @Override
    public Pair<Engine, String> parseSql(String sql) {
        if(StringUtils.isEmpty(sql)){
            throw new SqlParseExeception("sql is empty");
        }
        sql = sql.trim();
        if(sql.endsWith(";"))
            sql = sql.substring(0,sql.length()-1);
        String lowerCaseSql = sql.toLowerCase();
        int i = lowerCaseSql.lastIndexOf(FOR);
        if (i < 0)
            throw new SqlParseExeception("you didn't specify the engine that SQL needs to run, " +
                    "please use the keyword of 'for' at the end of SQL to indicate the engine ");


        String type = null;
        try {
            type = sql.substring(i + 4).trim();
        } catch (StringIndexOutOfBoundsException e) {
            throw new SqlParseExeception("After the keyword of 'for', you must specify the engine name," +
                    "eg. 'select * from dbname for mysql;'");
        }

        Engine engine = SupportEngineTool.toEngine(type);
        if(engine == null){
            String msg = "not support engine " + type;
            LOG.error(msg);
            throw new SqlParseExeception(msg);
        }
        String relSql = sql.substring(0, i).trim() + ";";
        return new Pair<>(engine, relSql);
    }


}
