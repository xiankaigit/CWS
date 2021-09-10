package com.xk.bigdata.cws;

import static org.junit.Assert.assertTrue;

import com.xk.bigdata.cws.common.tools.engine.Engine;
import com.xk.bigdata.cws.sql.parser.rule.RuleSqlParse;
import javafx.util.Pair;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        RuleSqlParse sqlParse = new RuleSqlParse();
        Pair<Engine, String> res = sqlParse.parseSql("select * from cws for flink ");
        System.out.println(res.getKey());
        System.out.println(res.getValue());
    }
}
