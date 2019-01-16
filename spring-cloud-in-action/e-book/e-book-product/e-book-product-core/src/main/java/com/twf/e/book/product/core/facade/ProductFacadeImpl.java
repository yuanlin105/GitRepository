package com.twf.e.book.product.core.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twf.e.book.product.api.domain.Product;
import com.twf.e.book.product.api.facade.ProductFacade;
import com.twf.e.book.product.core.service.ProductService;

@RestController
public class ProductFacadeImpl implements ProductFacade{

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="findAllProduct",method=RequestMethod.GET)
	public List<Product>findAllProduct() {
		return this.productService.listProduct();
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product>listProduct() {
		List<Product> list = this.productService.listProduct();
		return list;
	}

	@Override
	public Product getProduct(Integer id) {
		return productService.selectByPrimaryKey(id);
	}

	@Override
	public Product getProduct2(@RequestBody Product obj) {
		return obj;
	}

	@Override
	public Product getProduct3(Integer id, String name) {
		return new Product(id,name);
	}

	@Override
	public Product addProduct(@RequestBody Product obj) {
		return obj;
	}
}
