package com.twf.e.book.product.core.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twf.e.book.product.api.domain.Product;
import com.twf.e.book.product.api.facade.ProductFacade;

@RestController
public class ProductFacadeImpl implements ProductFacade{

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product>listProduct() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "登山包"));
		list.add(new Product(2, "登山杖"));
		list.add(new Product(3, "冲锋衣"));
		list.add(new Product(4, "帐篷"));
		list.add(new Product(5, "睡袋"));
		return list;
	}
}
