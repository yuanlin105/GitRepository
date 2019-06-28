package com.twf.eureka.consumer.Lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerLbApplication {
	
	/**与appliacation.properties 中配置 如下指令等效
	 * eureka-provider.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule
	 * @return
	 */
	@Bean
	public IRule ribbonRule() {  // 配置负载均衡策略
		return new RandomRule(); // 这里配置的是随机策略
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerLbApplication.class, args);
	}
}
