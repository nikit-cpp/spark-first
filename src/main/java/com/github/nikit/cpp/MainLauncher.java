package com.github.nikit.cpp;

import com.github.nikit.cpp.bean.SparkBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by nik on 25.09.16.
 */
@SpringBootApplication(scanBasePackages = {"com.github.nikit.cpp"})
public class MainLauncher {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext app = SpringApplication.run(MainLauncher.class, args);
        SparkBean sparkBean = app.getBean(SparkBean.class);
        sparkBean.run();
    }

}
