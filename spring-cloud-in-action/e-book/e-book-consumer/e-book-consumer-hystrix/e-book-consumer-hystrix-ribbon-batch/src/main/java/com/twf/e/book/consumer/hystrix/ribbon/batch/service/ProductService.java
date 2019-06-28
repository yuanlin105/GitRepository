package com.twf.e.book.consumer.hystrix.ribbon.batch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.twf.e.book.consumer.hystrix.ribbon.batch.domain.Product;

@Service
public class ProductService {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient; // ribbon的负载均衡客户端
	// 利用hystrix合并请求
	@HystrixCollapser(batchMethod = "batchProduct", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {
			// 请求时间间隔在20ms之内的请求会被合并为一个请求
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
			// 设置触发批处理执行之前，在批处理中允许的最大请求数
			@HystrixProperty(name = "maxRequestsInBatch", value = "200") })
	public Future<Product> getProduct(Integer id) {
		System.out.println("---------" + id + "----------");

		return null;
	}

	@HystrixCommand
	public List<Product> batchProduct(List<Integer> ids) {
		for (Integer id : ids) {
			System.out.println(id);
		}
		ServiceInstance si = loadBalancerClient.choose("e-book-product");
		StringBuffer sb = new StringBuffer("");
		sb.append("http://");
		sb.append(si.getHost());
		sb.append(":");
		sb.append(si.getPort());
		sb.append("/product/list");
		System.out.println(sb.toString());
		
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>(){};
		ResponseEntity<List<Product>> resp = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, typeRef);
		List<Product> plist = resp.getBody();		
		return plist;
		
//		List<Product> list = new ArrayList<Product>();
//		list.add(new Product(1, "登山包"));
//		list.add(new Product(2, "登山杖"));
//		list.add(new Product(3, "冲锋衣"));
//		list.add(new Product(4, "帐篷"));
//		list.add(new Product(5, "睡袋"));
//		list.add(new Product(6, "登山鞋"));
//		return list;
	}
}
