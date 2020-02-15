package com.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cs.mapper")
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","|{}");
    }
}
