package com.twf.eureka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twf.eureka.consumer.domain.Product;
import com.twf.eureka.consumer.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product>listProduct() {
		List<Product> list = productService.listProduct();
		return list;
	}
}
