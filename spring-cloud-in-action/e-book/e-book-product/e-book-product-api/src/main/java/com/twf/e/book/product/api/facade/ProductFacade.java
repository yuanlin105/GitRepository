package com.twf.e.book.product.api.facade;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.twf.e.book.product.api.domain.Product;

@RequestMapping("/product")
public interface ProductFacade {

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product> listProduct();
}
