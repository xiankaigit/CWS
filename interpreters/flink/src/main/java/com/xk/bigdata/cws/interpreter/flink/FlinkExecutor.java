package com.xk.bigdata.cws.interpreter.flink;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/24 下午2:48
 */
public class FlinkExecutor {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment blinkStreamEnv = StreamExecutionEnvironment.createRemoteEnvironment("10.33.57.32",8081,"/home/hik/workspace/java/CWS-0.0.1-release/interpreters/flink/target/cws-interpreter-flink-0.0.1-snapshot-jar-with-dependencies.jar");
        blinkStreamEnv.setParallelism(1);
        EnvironmentSettings blinkStreamSettings = EnvironmentSettings.newInstance()
                .useBlinkPlanner()
                .inStreamingMode()
                .build();
        StreamTableEnvironment.create(blinkStreamEnv,blinkStreamSettings);
        StreamTableEnvironment blinkStreamTableEnv = StreamTableEnvironment.create(blinkStreamEnv, blinkStreamSettings);

        String ddlSource =
                "CREATE TABLE user_behavior (\n" +
                "    user_id BIGINT,\n" +
                "    item_id BIGINT,\n" +
                "    category_id BIGINT,\n" +
                "    behavior STRING,\n" +
                "    ts TIMESTAMP(3)\n" +
                ") WITH (\n" +
                "    'connector.type' = 'kafka',\n" +
                "    'connector.version' = 'universal',\n" +
                "    'connector.topic' = 'test1',\n" +
                "    'connector.startup-mode' = 'latest-offset',\n" +
                "    'connector.properties.zookeeper.connect' = '10.33.57.52:2181',\n" +
                "    'connector.properties.bootstrap.servers' = '10.33.57.52:9092',\n" +
                "    'format.type' = 'json'\n" +
                ")";

        String ddlSink =
                "CREATE TABLE user_behavior_sink (\n" +
                "    user_id BIGINT,\n" +
                "    item_id BIGINT\n" +
                ") WITH (\n" +
                "    'connector.type' = 'kafka',\n" +
                "    'connector.version' = 'universal',\n" +
                "    'connector.topic' = 'fail-test',\n" +
                "    'connector.properties.zookeeper.connect' = '10.33.57.52:2181',\n" +
                "    'connector.properties.bootstrap.servers' = '10.33.57.52:9092',\n" +
                "    'format.type' = 'json',\n" +
                "    'update-mode' = 'append'\n" +
                ")";

        //提取读取到的数据，然后只要两个字段，重新发送到 Kafka 新 topic
        String sql = "insert into user_behavior_sink select user_id, item_id from user_behavior";

        System.out.println(ddlSource);
        System.out.println(ddlSink);

        blinkStreamTableEnv.executeSql(ddlSource);
        blinkStreamTableEnv.executeSql(ddlSink);
        blinkStreamTableEnv.executeSql(sql);

        blinkStreamEnv.execute("Blink Stream SQL Job2");

//        blinkStreamEnv.execute("Blink Stream SQL Job2");
    }
}
