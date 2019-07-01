package com.twf.e.book.consumer.hystrix.feign.fallback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twf.e.book.consumer.hystrix.feign.fallback.service.ProductService;
import com.twf.e.book.consumer.hystrix.feign.fallback.service.ProductService2;
import com.twf.e.book.product.api.domain.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductService2 productService2;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product> listProduct() {
		List<Product> list = productService.listProduct();
		return list;
	}
	@RequestMapping(value="list2",method=RequestMethod.GET)
	public List<Product> listProduct2() {
		List<Product> list = productService2.listProduct();
		return list;
	}
}
