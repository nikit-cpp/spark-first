package com.github.nikit.cpp.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nik on 25.09.16.
 */
@Configuration
public class SparkConfig {

    @Value("${custom.spark.master.url}")
    private String sparkMasterUrl;

    @Bean(destroyMethod = "close")
    public JavaSparkContext sc() {
        SparkConf conf = new SparkConf();
        conf.setMaster(sparkMasterUrl);
        conf.setAppName("Simple Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        return sc;
    }
}
