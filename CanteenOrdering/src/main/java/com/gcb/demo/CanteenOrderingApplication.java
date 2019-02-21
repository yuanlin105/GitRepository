package com.gcb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.gcb.demo.dao")
@ComponentScan(basePackages= {"com.gcb.demo"})
public class CanteenOrderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanteenOrderingApplication.class, args);
	}

}








