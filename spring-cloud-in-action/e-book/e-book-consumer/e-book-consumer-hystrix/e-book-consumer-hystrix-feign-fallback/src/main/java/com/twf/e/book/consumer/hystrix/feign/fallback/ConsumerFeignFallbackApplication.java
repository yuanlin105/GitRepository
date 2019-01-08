package com.twf.e.book.consumer.hystrix.feign.fallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerFeignFallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignFallbackApplication.class, args);
	}
}
