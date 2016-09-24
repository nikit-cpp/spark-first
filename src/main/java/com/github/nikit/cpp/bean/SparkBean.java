package com.github.nikit.cpp.bean;

import org.apache.spark.SparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by nik on 25.09.16.
 */
@Component
public class SparkBean {

    @Autowired
    private JavaSparkContext sc;

    @Value("classpath:README.md")
    private File file;

    public void run() throws Exception {

        JavaRDD<String> logData = sc.textFile(file.getCanonicalPath()).cache();

        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("a"); }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("b"); }
        }).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
    }
}
