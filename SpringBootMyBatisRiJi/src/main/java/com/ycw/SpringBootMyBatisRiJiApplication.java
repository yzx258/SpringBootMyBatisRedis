package com.ycw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.ycw.dao")
public class SpringBootMyBatisRiJiApplication extends SpringBootServletInitializer{
	   
		@Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SpringBootMyBatisRiJiApplication.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisRiJiApplication.class, args);
	}
}
